package p26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak5 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");



        WebElement checkbox = driver.findElement(By.cssSelector("label"));
        checkbox.click();

        if ( driver.findElement(By.cssSelector("svg.rct-icon.rct-icon-check")).isSelected()) {
            System.out.println("Element je cekiran.");
        }

        driver.quit();
    }

}
