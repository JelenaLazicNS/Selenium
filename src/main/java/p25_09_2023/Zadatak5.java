package p25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;


public class Zadatak5 {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> links = new ArrayList<>();
        links.add("https://google.com/");
        links.add("https://youtube.com/");
        links.add("https://www.ebay.com/");
        links.add("https://www.kupujemprodajem.com/");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        for (String link:links) {
            driver.navigate().to(link);
            System.out.println(driver.getTitle());
            Thread.sleep(5000);
        }

        Thread.sleep(5000);
        driver.quit();
    }
}
