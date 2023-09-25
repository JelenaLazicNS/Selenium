package p25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.crypto.agreement.srp.SRP6Client;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {

        String userName = "itBootcamp";
        String password = "ITBootcamp2021!";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/login ");

        driver.findElement(By.xpath("//input[@id='userName']")).clear();
        driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(userName);

        driver.findElement(By.xpath("//input[@placeholder='Password']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);

        driver.findElement(By.xpath("//form[@id='userForm']/div[4]/div[1]/button")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[text()='Log out']")).click();

        driver.quit();

    }
}
