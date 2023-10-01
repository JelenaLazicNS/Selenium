package p29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak4 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.navigate().to("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");

        WebElement primaryButton = driver.findElement(By.id("basic-primary-trigger"));
        primaryButton.click();

        WebElement toasts;
        toasts = wait
                .withMessage("Element se pojavio")
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.name("toast-primary")));

        toasts = wait
                .withMessage("Element se izgubio")
                .until(ExpectedConditions
                        .visibilityOf(toasts));

        primaryButton.click();

        wait
                .withMessage("Element se pojavio")
                .until(ExpectedConditions.presenceOfElementLocated(By.name("toast-primary")));

        driver
                .findElement(By.name("btn-close")).click();

        wait
                .withMessage("Element se vidi")
                .until(ExpectedConditions.visibilityOf(toasts));

        wait
                .withMessage("Element se izgubio")
                .until((ExpectedConditions.stalenessOf(toasts)));

    }

}
