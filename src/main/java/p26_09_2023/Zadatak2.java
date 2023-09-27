package p26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://s.bootsnipp.com/iframe/z80en");

        List<WebElement> prviTab = driver.findElements(By.xpath("//table/tbody/tr[1]"));
        for (int i = 0; i< prviTab.size(); i++) {
            System.out.println();
            Thread.sleep(1000);

        List<WebElement> prviRed = driver.findElements(By.xpath("//table/tbody/tr[1]/td"));
        {
            for (WebElement element : prviRed) {
                System.out.println(element.getText());
            }
            Thread.sleep(5000);
        }

    }driver.quit();
}
}