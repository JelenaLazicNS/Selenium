package p28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://demoqa.com/modal-dialogs");
        driver.findElement(By.id("showLargeModal")).click();

   TestHelper testHelper = new TestHelper(driver);
    testHelper.setDefaultImplicitWait();

    boolean x = testHelper.elementExists(By.id("example-model-size-title-lg"));

  //  boolean elementExists = testHelper.elementExists();

 //   boolean elementExistsByList = testHelper.elementExistsByList();

    testHelper.setImplicitWait(8);

    }
}
