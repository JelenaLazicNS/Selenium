package d02_10_2023;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Domaci2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://itbootcamp.rs/");
        List<WebElement> hoverable = driver.findElements(By.cssSelector("#menu-main-menu > li > a"));
        List<WebElement> menu = driver.findElements(By.cssSelector("#menu-main-menu ul"));

        for (int i = 1; i < 4; i++) {

            new Actions(driver)
                    .moveToElement(hoverable.get(i))
                    .perform();

            wait
                    .withMessage("Padajuci meni nije vidljiv")
                    .until(ExpectedConditions.visibilityOf(menu.get(i-1)));

        }

        driver.quit();

    }
    }

