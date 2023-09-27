package d25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Domaci1 {
    public static void main(String[] args) throws InterruptedException {

        String userName = "Admin";
        String password = "admin123";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.xpath("//input[@placeholder='Username']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Username']"))
                .sendKeys(userName);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Password']"))
                .sendKeys(password);
        driver.findElement(By.xpath("//form/div[3]/button")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//input[@placeholder='Search']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Search']"))
                        .sendKeys("Me");
        driver.findElement(By.xpath("/ul/li[1]/a/span"))
                        .click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//ul/li/span/img"))
                        .click();
        driver.findElement(By.xpath("//ul/li/ul/li[4]/a"))
                        .click();
        Thread.sleep(5000);

        driver.quit();




    }
}
