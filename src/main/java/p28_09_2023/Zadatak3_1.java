package p28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak3_1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.get("file:///C:/Users/user/Downloads/Zadatak4.html");

      //  WebElement btn = driver.findElement(By.id("showInBtn"));
      //  System.out.println("Kreni da cekas uslov");
      //  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("div#id-0")));
      //  System.out.println("Kraj");

        for (int i=0; i<=5; i++) {
            WebElement btn = driver.findElement(By.id("showInBtn"));
            btn.click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("div#id-"+i)));
        }

    }
}
