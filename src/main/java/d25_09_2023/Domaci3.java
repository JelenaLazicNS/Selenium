package d25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Domaci3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php");

        for (int i = 0; i <= 5; i++) {
            driver.findElement(By.cssSelector("button.add-new")).click();
            driver.findElement(By.cssSelector("input[name='name']")).sendKeys("Zorica Stanic");
            driver.findElement(By.cssSelector("input[name='department']")).sendKeys("HR");
            driver.findElement(By.cssSelector("input[name='phone']")).sendKeys("524732-3543");
            driver.findElement(By.xpath("//tbody/tr[last()]/td[last()]/a[@class='add']")).click();
            Thread.sleep(500);
        }
        driver.quit();
    }
}

