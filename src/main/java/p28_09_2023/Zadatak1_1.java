package p28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak1_1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/modal-dialogs");

        List<WebElement> buttons =
                driver.findElements(By.id("showLargeModal"));

        if (buttons.isEmpty()) {
            System.out.println("Ne postoji element");
        } else {
            System.out.println("Postoji element");
        }

    }
}
