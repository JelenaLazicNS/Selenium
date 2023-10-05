package p02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.io.IO;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class Zadatak3 {
    public static void main(String[] args) throws IOExeption, IOException {
        String url="";
        String downloadFilePath = "downloads/parrot.jpg";

        Helper.downloadUsingStream(url, downloadFilePath);
        }
    }




