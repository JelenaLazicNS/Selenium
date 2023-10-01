package p29_09_2023;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak3 {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriver.get("https://s.bootsnipp.com/iframe/8dqr");

        webDriver.findElement(By.xpath("//div[@class='panel panel-success']//span"));
        WebElement search = webDriver.findElement(By.xpath("//div[@class='panel panel-success']//input[@class='form-control']"));
        wait.withMessage("Greska!")
                .until(ExpectedConditions.visibilityOf(search));
        search.sendKeys("dsdsdsds");

        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//tr[@class='filterTable_no_results']/td"), "No results found"));
        webDriver.quit();

    }
}
