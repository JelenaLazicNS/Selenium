package p26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(" https://s.bootsnipp.com/iframe/z80en");

        List<WebElement> rows =
                driver.findElements(By.cssSelector("div#lorem>table>tbody>tr "));
        for (int i=0; i< rows.size(); i++){
            List<WebElement> columns=
                    rows.get(i).findElements(By.tagName("td"));
            for(int j=0; j<columns.size(); j++){
                System.out.println(columns.get(j).getText()+"\t\t\t |");
            }
            System.out.println();
            Thread.sleep(5000);
        } driver.quit();
    }
}
