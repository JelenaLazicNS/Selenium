package p25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/webtables");
        driver.findElement(By.id("edit-record-1"))
                .click();
        driver.findElement(By.id("firstName"))
                .clear();
        driver.findElement(By.id("firstName"))
                .sendKeys("lkjlj");

        driver.findElement(By.id("lastName"))
                .clear();
        driver.findElement(By.id("lastName"))
                .sendKeys("čljč");

        driver.findElement(By.id("userEmail"))
                .clear();
        driver.findElement(By.id("userEmail"))
                .sendKeys("kgk@kuhzk.com");

        driver.findElement(By.id("age"))
                .clear();
        driver.findElement(By.id("age"))
                .sendKeys("55");

        driver.findElement(By.id("salary"))
                .clear();
        driver.findElement(By.id("salary"))
                .sendKeys("5555");

        driver.findElement(By.id("department"))
                .clear();
        driver.findElement(By.id("department"))
                .sendKeys("kuhl");

        driver.findElement(By.id("submit"))
                .click();
        Thread.sleep(2000);

        driver.quit();



    }
}
