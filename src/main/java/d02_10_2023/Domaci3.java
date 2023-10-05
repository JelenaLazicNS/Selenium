package d02_10_2023;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.List;


public class Domaci3 {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://itbootcamp.rs/");

        WebElement slider = driver.findElement(By.cssSelector("div.owl-stage"));

        new Actions(driver)
                .scrollToElement(slider)
                .perform();

        List<WebElement> links = driver.findElements(By.cssSelector("div.owl-stage img"));

        for (int i = 0; i < links.size() ; i++) {
            String url = links.get(i).getAttribute("src");

            if (getHTTPResponseStatusCode(url) >= 200 && getHTTPResponseStatusCode(url)< 300) {

                try{
                    download(url, "itbootcamp_slider/slika" + i + ".jpg");

                } catch (IOException e) {

                    e.printStackTrace();
                }
            }

        }

        driver.quit();
    }

    public static int getHTTPResponseStatusCode(String u) throws IOException {
        URL url = new URL(u);
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        return http.getResponseCode();
    }
    public static void download(String urlStr, String file) throws IOException {
        URL url = new URL(urlStr);
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream(file);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        fos.close();
        rbc.close();
    }
}
