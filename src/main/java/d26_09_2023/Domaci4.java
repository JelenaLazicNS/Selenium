package d26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Domaci4 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.calculatorsoup.com/calculators/math/basic.php");

        String formula = "1243+329=";

        List<Character> chars = new ArrayList<>();

        char[] characters = formula.toCharArray();
        WebElement formulaInput = driver.findElement(By.cssSelector("input#cs_display.cs_window"));

        for (char character : characters) {
            switch (character) {
                case '+':
                case '-':
                case '*':
                case '/':
                case '=':
                    WebElement calculatorButton = driver.findElement(By.id("btn" + character));
                    calculatorButton.click();
            }
        } formulaInput.submit();
        WebElement resultElement = driver.findElement(By.id("res"));
        String result = resultElement.getText();
        System.out.println("Result: " + result);
    }


}
