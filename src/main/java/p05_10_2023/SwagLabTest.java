package p05_10_2023;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;
import org.testng.Assert;

import java.rmi.server.ExportException;
import java.time.Duration;

public class SwagLabTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl = "https://www.saucedemo.com/";

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void beforeMethod (){
        driver.navigate().to(baseUrl);
    }

    @Test (priority =1, retryAnalyzer = SwagLabsRetry.class)
    public void verifyErrorIsDisplayedWhenUserNameIsMissing(){
        driver.findElement(By.id("login-button")).click();

        wait.
                withMessage("Error message is not displayed when username is missing.")
                .until(ExpectedConditions
                        .textToBePresentInElementLocated(
                                By.cssSelector(".error-message-container h3"),
                                "Username is required"));
    }

    @Test (priority = 2, retryAnalyzer = SwagLabsRetry.class)
    public void verifyErrorIsDisplayedWhenPasswordIsMissing() {
        String username = "standard_user";

        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("login-button")).click();

        wait
                .withMessage("Error message is not displayed when password is missing.")
                .until(ExpectedConditions
                        .textToBePresentInElementLocated(
                                By.cssSelector(".error-message-container h3"),
                                "Password is required"));
    }
    @Test (priority = 3, retryAnalyzer = SwagLabsRetry.class)
    public void verifyErrorIsDisplayedWhenCredentialsAreWrong(){
        String username = "standard_user";
        String password = "invalidpassword";

        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.name("login-button")).click();

        wait
                .withMessage("Error message is not displayed when password is missing.")
                .until(ExpectedConditions
                        .textToBePresentInElementLocated(By.cssSelector(".error-message-container h3"),
                                "Username and password do not match any user in this service"));
    }

    @Test(priority = 4, retryAnalyzer = SwagLabsRetry.class)
    public void verifyErrorIsDisplayedWhenUserIsLocked() {
        String username = "locked_out_user";
        String password = "secret_sauce";

        driver.findElement(By.name("user-name")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        Assert.assertEquals(driver.findElement(By.xpath(
                        "//*[@id='login_button_container']//form//h3")).getText(),
                "Epic sadface: Sorry, this user has been locked out.",
                "Error message for locked out user should be present");
    }

    @Test (priority = 5, retryAnalyzer = SwagLabsRetry.class)
    public void verifySuccessfulLogin(){
        String username = "standard user";
        String password = "secret_sauce";

        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.name("login-button")).click();

        Assert.assertEquals(
                driver.getCurrentUrl(),
                baseUrl + "/inventory.html",
                "Should be redirected to inventory page after login.");

        driver.findElement(By.id("react-burger-menu-btn")).click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.className("bm-menu-wrap")));

        boolean loginFormExists=
                !driver.findElements(By.className("login_wrapper")).isEmpty();

        Assert.assertTrue(
                loginFormExists,
                "Should be redirected to login page after logout.");

    }


    @Test(priority = 6, retryAnalyzer = SwagLabsRetry.class)
    public void addingProductsToCart() {
        String username = "standard_user";
        String password = "secret_sauce";

        driver.findElement(By.name("user-name")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        wait.until(ExpectedConditions.urlContains("/inventory.html"));
        wait.withMessage("Url doesn't contain /inventory.html");

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("remove-sauce-labs-backpack")));
        wait.withMessage("Remove button is not present");

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a/span"))
                        .getText(),
                "1", "Number of products should be 1");
    }

    @Test(priority = 7, retryAnalyzer = SwagLabsRetry.class)
    public void viewingProductDetails() {
        String username = "standard_user";
        String password = "secret_sauce";

        driver.findElement(By.name("user-name")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        wait.until(ExpectedConditions.urlContains("/inventory.html"));
        wait.withMessage("Url doesn't contain /inventory.html");

        driver.findElement(By.id("item_4_title_link")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.inventory_details_price")));
        wait.withMessage("The price is invisible.");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .cssSelector("div.inventory_details_desc.large_size")));
        wait.withMessage("The description is invisible.");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-cart-sauce-labs-backpack")));
        wait.withMessage("Add to cart button is invisible");

    }


    @Test(priority = 8, retryAnalyzer = SwagLabsRetry.class)
    public void removingProductsFromCart() {
        String username = "standard_user";
        String password = "secret_sauce";

        driver.findElement(By.name("user-name")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        wait.until(ExpectedConditions.urlContains("/inventory.html"));
        wait.withMessage("Url doesn't contain /inventory.html");

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a/span"))
                        .getText(),
                "1", "Number of products should be 1");

        driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("#item_4_title_link > div")).getText(),
                "Sauce Labs Backpack", "Sauce Labs Backpack should be present in cart.");

        driver.findElement(By.id("remove-sauce-labs-backpack")).click();

        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath
                ("//div[text()='Sauce Labs Backpack']"), 0));
        wait.withMessage("Cart is not empty");

    }


    @Test(priority = 9, retryAnalyzer = SwagLabsRetry.class)
    public void productCheckout() {
        String username = "standard_user";
        String password = "secret_sauce";
        String checkoutName = "Pera";
        String checkoutLastName = "Peric";
        String checkoutZip = "18000";

        driver.findElement(By.name("user-name")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        wait.until(ExpectedConditions.urlContains("/inventory.html"));
        wait.withMessage("Url doesn't contain /inventory.html");

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a/span")).getText(),
                "1", "Number of products should be 1");

        driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a")).click();

        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys(checkoutName);
        driver.findElement(By.id("last-name")).sendKeys(checkoutLastName);
        driver.findElement(By.id("postal-code")).sendKeys(checkoutZip);
        driver.findElement(By.id("continue")).click();


        wait.until(ExpectedConditions.numberOfElementsToBe(By
                .cssSelector("#checkout_summary_container div.cart_quantity"), 1));

        Assert.assertTrue(driver.findElement(By.cssSelector("div.summary_subtotal_label")).getText()
                        .contains(driver.findElement(By.cssSelector("div.item_pricebar > div")).getText()),
                "Prices in item pricebar and subtotal should be equal.");

        driver.findElement(By.id("finish")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='checkout_complete_container']/h2"))
                        .getText(),
                "Thank you for your order!", "Message should be equal to: Thank you for your order!");
    }


    @AfterMethod
    public void afterMethod(){
        driver.manage().deleteAllCookies(); //izloguje
        ((JavascriptExecutor)driver).executeScript("window.localStorage.clear();");
    }
    @AfterClass
    public void afterClass (){
        driver.quit();
    }



}
