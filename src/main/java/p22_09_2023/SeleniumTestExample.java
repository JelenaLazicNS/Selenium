package p22_09_2023;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTestExample {
    public static void main(String[] args) throws InterruptedException {
        // Postavljanje ChromeDriver koristeći WebDriverManager
        WebDriverManager.chromedriver().setup();
        // Kreiranje instance ChromeDriver-a
        WebDriver driver = new ChromeDriver();
        // Otvaranje veb stranice
        driver.get("https://google.com");
        //500ms => 0.5s
        Thread.sleep(500);
        driver.get("https://facebook.com");
        Thread.sleep(1000);
        driver.get("https://youtube.com");
        Thread.sleep(5000);
        // Mesto za test kod ...


        // Zatvoranje pretrazivaca nakon sto se zavrsi testiranje
         driver.quit();
    }
}

