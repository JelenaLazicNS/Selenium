package d26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;

public class Domaci3 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://example.cypress.io/todo");

        String[] todos = {"Visit Paris", "Visit Prague", "Visit London", "Visit New York", "Visit Belgrade", "Maximize the window"};

        for (String todo : todos) {
            WebElement todoInput = driver.findElement(By.cssSelector("input.new-todo"));
            todoInput.sendKeys(todo);
            todoInput.submit();
            System.out.println("Dodaj todo: " + todo);
        }
        WebElement todoItem = driver.findElement(By.xpath("//span[text()='" + Arrays.toString(todos) + "']"));
        if (todoItem.isDisplayed()) {
            System.out.println("Todo uspesno dodat.");
        } else {
            System.out.println("Todo nije dodat.");
        }
        for (String todo : todos) {
          //  WebElement todoItem = driver.findElement(By.xpath("//span[text()='" + todo + "']"));
            WebElement deleteButton = todoItem.findElement(By.xpath("../button"));
            deleteButton.click();
            System.out.println("Deleted todo: " + todo);
    }
        int remainingTodos = driver.findElements(By.cssSelector("li")).size();
        if (remainingTodos == 0) {
            System.out.println("All todos have been deleted.");
        } else {
            System.out.println("Not all todos have been deleted.");
        }
        driver.quit();
    }
}
