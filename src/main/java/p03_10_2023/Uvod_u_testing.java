package p03_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import p28_09_2023.TestHelper;

import java.time.Duration;

public class Uvod_u_testing {

    private WebDriver driver;
    private WebDriverWait wait;


    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @BeforeMethod
    public void beforeMethod () {
        driver.navigate().to("http://google.com");

    }
    @Test
    public void googleTitleTest() {
        Assert.assertTrue(driver.getTitle().contains("Google"), "lkjikjh");
      //  Assert.assertEquals(driver.getTitle(),
      //          "Google98",
       //         "Home page title should be ˙Google98´");
        Assert.assertEquals(driver.getCurrentUrl(),
                "http://google.com", 
                "Ide Poruka" );
        
        TestHelper testHelper = new TestHelper(driver);
        boolean elementExist = testHelper.elementExists(By.name("lkjlkj"));
        Assert.assertFalse(elementExist);
        wait
                .withMessage("");
       //         .until(ExpectedConditions.numberOfElementsToBe(By.name("")));

        WebElement searchInput = driver.findElement(By.name("q"));

        searchInput.sendKeys("it bootcamp");
        searchInput.sendKeys(Keys.ENTER);

        wait
                .withMessage("After search title should include ´ít bootcamp˙")
                .until(ExpectedConditions.titleContains("it bootcampdfdfdf"));
    }
    @Test
    public void googleSearchTest () {
        driver
                .findElement(By.name("kdfhgkgfk"))
                .sendKeys("IT Bootcamp");

         driver.navigate().to("http://youtube.com");

    }
    @AfterMethod
    public void afterMethod() {

    }
    @AfterClass
    public void afterClass (){
        driver.quit();

    }


}
