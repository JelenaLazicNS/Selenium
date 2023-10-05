package p02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to("https://tus.io/demo.html");

        File fileUpload = new File("test_data/parrot.jpg");

        driver
                .findElement(By.id("P0-0"))
                .sendKeys(fileUpload.getAbsolutePath());

        wait
                .withMessage("Pojavilo se dugme za download")
                .until(ExpectedConditions.presenceOfElementLocated(By.className("primary")));

     //   driver
     //           .findElement(By.xpath("/html/body/main/astro-island[1]/div/div/a"))
     //           .click();

        driver.quit();

    }

}
