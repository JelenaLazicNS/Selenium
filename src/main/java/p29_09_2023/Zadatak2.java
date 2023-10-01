package p29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://youtube.com");

        driver
                .findElement(By.name("search-query"))
                .click();
        Thread.sleep(1000);
        driver
                .findElement(By.name("search-query"))
                .sendKeys("Oasis");

        wait
                .withMessage("Pretraga nije prikazala preporuke")
                .until(ExpectedConditions
                        .numberOfElementsToBeMoreThan(
                                By.cssSelector("[role=`Presentation`]"), 2));

        Thread.sleep(5000);

        driver.quit();
    }
}
