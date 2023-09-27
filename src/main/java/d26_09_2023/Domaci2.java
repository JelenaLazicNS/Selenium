package d26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Domaci2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://s.bootsnipp.com/iframe/Dq2X");

        List<WebElement> deleteElements = driver.findElements(By.className("close"));
        for (int i = 0; i < deleteElements.size(); i++) {
            WebElement deleteElement = deleteElements.get(i);
            deleteElement.click();

            boolean isDeleted = !isElementPresent(driver, By.className("close"));

            if (isDeleted) {
                System.out.println("Element " + i + " uspesno obrisan.");
            } else {
                System.out.println("Element " + i + " nije obrisan.");
            } Thread.sleep(1000);
            deleteElements = driver.findElements(By.className("close"));

        }
        driver.quit();
    }

    private static boolean isElementPresent(WebDriver driver, By close) {
        return false;
    }

}
