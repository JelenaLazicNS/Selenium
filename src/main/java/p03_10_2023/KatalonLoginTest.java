package p03_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class KatalonLoginTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl = "https://cms.demo.katalon.com";

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @BeforeMethod
    public void beforeMethod() {

        driver.navigate().to(baseUrl);
    }

    @Test(priority = 1)
    public void visitLoginPageFromNavBar() {
        driver
                .findElement(By.linkText("MY ACCOUNT"))
                .click();

        wait
                .withMessage("Sould be redirected to my account page.")
                .until(ExpectedConditions.titleContains("My account - Katalon Shop"));

        wait
                .withMessage("Sould be redirected to my account page")
                .until(ExpectedConditions.urlContains("/my-account"));
    }

    @Test(priority = 2)
    public void checkInputTypes() {
        driver
                .findElement(By.linkText("MY ACCOUNT"))
                .click();
        wait
                .withMessage("Sould be redirected to my account page")
                .until(ExpectedConditions.titleContains("My account - Katalon Shop"));

        Assert.assertEquals(
                driver.findElement(By.id("username")).getAttribute("type"),
                "text," +
                        "Username input should be text type.");
        Assert.assertEquals(
                driver.findElement(By.id("password")).getAttribute("type"),
                "password",
                "Password input should be password type.");

        Assert.assertEquals(
                driver.findElement(By.id("rememeberme")).getAttribute("type"),
                "checkbox",
                "Remember me checkbox should be checkbox type.");

        Assert.assertEquals(
                driver.findElement(By.id("rememberme")).isSelected(),
                "Rememeber me should be unchecked by default.");
    }

        @Test(priority = 3)
        public void displayErrorWhenCredentialsAreWrong (){
            String email = "invalidemail@gmail.com";
            String password = "invalid123";

            driver.findElement(By.id("username")).sendKeys(email);
            driver.findElement(By.id("password")).sendKeys(password);
            driver.findElement(By.name("login")).click();

            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".woocomerce-error li")));
            wait.until(ExpectedConditions.textToBePresentInElementLocated(
                    By.cssSelector(".woocomerce-error li"),
                    "Invalid email address"));

            Assert.assertTrue(driver.getCurrentUrl().contains("/my-account"),
                    "After failed login should stay on same page.");
        }

            @Test(priority = 4)
            public void successfulLoginWithValidCredentials () {
                String email = "customer";
                String password = "crz7mrb.KNG3yxvlfbn";

                driver.findElement(By.id("username")).sendKeys(email);
                driver.findElement(By.id("password")).sendKeys(password);
                driver.findElement(By.name("login")).click();

                wait
                        .withMessage("...")
                        .until(ExpectedConditions.presenceOfElementLocated(
                                By.linkText("Logout")));

            }

            @AfterClass
            public void afterClass () {
                driver.quit();

            }
}

