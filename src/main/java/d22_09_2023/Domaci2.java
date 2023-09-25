package d22_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Domaci2 {
    public static void main(String[] args) {

        ArrayList<String> nizStranica = new ArrayList<>();
        nizStranica.add("https://www.google.com/");
        nizStranica.add("https://www.facebook.com/");
        nizStranica.add("https://www.youtube.com/");
        nizStranica.add("https://www.ebay.com/");
        nizStranica.add("https://www.katalon.com/");

        for (String stranica : nizStranica) {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get(stranica);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }driver.quit();
        }


    }
}
