package d25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Domaci2 {
    public static void main(String[] args) throws InterruptedException {

        ArrayList<String> toDo = new ArrayList<>();
        toDo.add("Visit Paris");
        toDo.add("Visit Prague");
        toDo.add("Visit London");
        toDo.add("Visit New York");
        toDo.add("Visit Belgrade");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://example.cypress.io/todo");

         for (int i = 0; i < toDo.size(); i++) {
         for (String todo:toDo) {
            WebElement todoInput = driver.findElement(By.className("new-todo"));
            todoInput.sendKeys(toDo.get(i));
            todoInput.sendKeys(Keys.ENTER);

            }
         driver.findElement(By.xpath("//ul/li[1]/div/button"))
                     .click();
         driver.findElement(By.xpath("//ul/li[2]/div/input"))
                     .click();
         driver.findElement(By.xpath("//ul/li[3]/div/input"))
                     .click();
         driver.findElement(By.xpath("//ul/li[4]/div/input"))
                     .click();
         driver.findElement(By.xpath("//ul/li[5]/div/input"))
                     .click();

            Thread.sleep(5000);

            driver.quit();
        }
    }
}
