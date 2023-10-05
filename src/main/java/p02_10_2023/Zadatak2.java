package p02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to("https://blueimp.github.io/jQuery-File-Upload");

        File fileUpload = new File("test_data/parrot.jpg");

        driver
                .findElement(By.name("files[]"))
                .sendKeys(fileUpload.getAbsolutePath());
        wait
                .until(ExpectedConditions.numberOfElementsToBe(By.name("template-upload"), 1));

        driver
                .findElement(By.name("btn-primary"))
                .click();
        wait
                .until(ExpectedConditions.presenceOfElementLocated(By.name("btn-danger")));

        driver
                .findElement(By.name("btn-danger"))
                .click();
        wait
                .until(ExpectedConditions.numberOfElementsToBe(By.xpath("//table/tbody"), 0));

        driver.quit();


    }
}
