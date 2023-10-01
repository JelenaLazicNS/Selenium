package p29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak6 {
    public static void main(String[] args) {
        long start = 0;
        long end = 0;
        start = System.currentTimeMillis();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.navigate().to("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");

        WebElement primaryButton = driver.findElement(By.id("basic-primary-trigger"));
        primaryButton.click();
        WebElement secondaryButton = driver.findElement(By.id("basic-secondary-trigger"));
        secondaryButton.click();
        WebElement successButton = driver.findElement(By.id("basic-success-trigger"));
        successButton.click();
        WebElement dangerButton = driver.findElement(By.id("basic-danger-trigger"));
        dangerButton.click();

        wait
                .withMessage("Tostovi su prikazani")
                .until(ExpectedConditions
                        .numberOfElementsToBe(By.xpath("//div[contains(@class,'toast-fixed show')]"), 4));

        double time = 0;
        wait
                .withMessage("Vreme koje je potrebno za izvrsenje: " + time + "s")
                .until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[contains(@class,'toast-fixed show')]"), 0));

        end = System.currentTimeMillis();
        time = (end - start) / 1000.0;
        System.out.println();
        driver.quit();
    }
}

//
//