package p29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://s.bootsnipp.com/iframe/klDWV");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        if (wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id='precent']"),"100%"))){
            System.out.println("Stranica ucitana");
       }
        driver.quit();

//jedan nacin:
      //  WebElement loader = driver.findElement(By.className("preloader-wrap"));

        //ili

    //    wait
    //            .withMessage("Stranica se nije ucitala!")
      //          .until((ExpectedConditions.
      //                  attributeContains(By.className("preloader-wrap"),
     //                           "style",
     //                           "display:none")));
      //

    }

}
