package tests;

import Pages.BasicPage;
import org.testng.annotations.Test;

public class ProductsTest extends BasicTest {

    @Test
    public void test1(){
        driver.navigate().to("https://google.com");
    }

}
