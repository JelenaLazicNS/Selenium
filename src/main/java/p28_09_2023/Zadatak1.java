package p28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/modal-dialogs");

        WebElement largeModal = null;
        boolean postojiElement = true;
        try {
            largeModal = driver.findElement(By.id("showLargeModal"));
        } catch (Exception e) {
            postojiElement = false;
            System.out.println("Ne postoji element");
        }
        if (postojiElement){
            largeModal.click();
            System.out.println("Postoji element");
        }

    }

}
