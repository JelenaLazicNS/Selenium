package d26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;

public class Domaci1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");

        Scanner scanner = new Scanner(System.in);

        WebElement firstNameInput = driver.findElement(By.id("firstName"));
        System.out.println("Unesite ime: ");
        String firstName = scanner.nextLine();
        firstNameInput.sendKeys(firstName);

        WebElement lastNameInput = driver.findElement(By.id("lastName"));
        System.out.print("Unesite prezime: ");
        String lastName = scanner.nextLine();
        lastNameInput.sendKeys(lastName);

        WebElement userEmailInput = driver.findElement(By.id("userEmail"));
        System.out.print("Unesite emaill: ");
        String email = scanner.nextLine();
        userEmailInput.sendKeys(email);

        WebElement gender = driver.findElement(By.xpath("//label[text()='Male']"));
        gender.click();

        WebElement userNumberInput = driver.findElement(By.id("userNumber"));
        System.out.print("Unesite broj telefona: ");
        String mobileNumber = scanner.nextLine();
        userNumberInput.sendKeys(mobileNumber);

        WebElement dateOfBirthInput = driver.findElement(By.id("dateOfBirthInput"));
        dateOfBirthInput.click();
        System.out.print("Unesite datum rodjenja (MM/DD/YYYY): ");
        String dob = scanner.nextLine();
        dateOfBirthInput.sendKeys(dob);

        WebElement subjectsInput = driver.findElement(By.id("subjectsInput"));
        System.out.print("Unesite predmet: ");
        String subjects = scanner.nextLine();
        subjectsInput.sendKeys(subjects);

        WebElement hobbiesCheckbox = driver.findElement(By.xpath("//label[text()='Reading']"));
        hobbiesCheckbox.click();

        WebElement currentAddressInput = driver.findElement(By.id("currentAddress"));
        System.out.print("Unesite trenutnu adresu: ");
        String currentAddress = scanner.nextLine();
        currentAddressInput.sendKeys(currentAddress);


        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();


        driver.quit();


        scanner.close();

    }
}
