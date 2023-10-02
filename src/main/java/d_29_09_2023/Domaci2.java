package d_29_09_2023;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Domaci2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

        driver.get("https://docs.katalon.com/");
        driver.manage().window().maximize();

        WebElement htmlElement = driver.findElement(By.tagName("html"));
        String themeAttribute = htmlElement.getAttribute("data-theme");
        System.out.println("Trenutna tema: " + themeAttribute);

        if (themeAttribute.equals("light")) {
            System.out.println("Tema je svetla (light).");
        } else {
            System.out.println("Tema nije svetla (light).");
        }

        WebElement themeButton = driver.findElement(By.xpath("//*[@id=\"__docusaurus\"]/nav/div[1]/div[2]/div[2]/button"));
        themeButton.click();

        themeAttribute = htmlElement.getAttribute("data-theme");
        System.out.println("Nova tema: " + themeAttribute);

        if (themeAttribute.equals("dark")) {
            System.out.println("Tema je tamna (dark).");
        } else {
            System.out.println("Tema nije tamna (dark).");
        }

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.LEFT_CONTROL).sendKeys("k").keyUp(Keys.LEFT_CONTROL).perform();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchDialog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("docsearch-input")));

        String searchInputType = searchDialog.getAttribute("type");
        System.out.println("Vrednost atributa 'type' za input: " + searchInputType);

        driver.quit();

    }
}
