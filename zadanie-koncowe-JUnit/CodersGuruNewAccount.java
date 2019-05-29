import org.junit.After;
import org.junit.Before;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class CodersGuruNewAccount {

    private WebDriver driver;

    @Before
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver","/home/zofia/tester-automat-kurs/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().window().setSize(new Dimension(800, 1200));
    }

    @After
    public void CLose() {
        driver.quit();
    }

    // Założenie konta firmowego

    @Test
    public void RegisterNewAccount() {

        // Dane testowe
        String url = "https://men-men-s-01.codersguru.pl/";
        String password = "misiaczek100";
        String email = "firma@2p.pl";
        String firstName = "Adam";
        String lastName = "Kowalski";
        String cityName = "Poznań";
        String postalCode = "60-000";
        String streetName = "Kokosowa";
        String houseNo = "11";
        String companyName = "Firma Kokosowa";

        // Pobieranie Nip
        driver.get("http://generatory.it/");
        WebElement nipNo = driver.findElement(By.id("nipBox"));
        String nip = nipNo.getText();

        // Rejestracja konta
        driver.get(url);
        WebElement linkRegister = driver.findElement(By.cssSelector("input.link"));
        linkRegister.click();

        WebElement buttonCompany = driver.findElement(By.id("company"));
        buttonCompany.click();

        WebElement emailForm = driver.findElement(By.id("fos_user_registration_form_email"));
        emailForm.sendKeys(email);

        WebElement firstNameForm = driver.findElement(By.id("fos_user_registration_form_name"));
        firstNameForm.sendKeys(firstName);

        WebElement lastNameForm = driver.findElement(By.id("fos_user_registration_form_lastname"));
        lastNameForm.sendKeys(lastName);


        WebElement passwordForm = driver.findElement(By.id("fos_user_registration_form_plainPassword_first"));
        passwordForm.sendKeys(password);

        WebElement passwordSecond = driver.findElement(By.id("fos_user_registration_form_plainPassword_second"));
        passwordSecond.sendKeys(password);

        WebElement cityForm = driver.findElement(By.id("form_city"));
        cityForm.sendKeys(cityName);

        WebElement postalCodeForm = driver.findElement(By.id("form_postal_code"));
        postalCodeForm.sendKeys(postalCode);

        WebElement streetForm = driver.findElement(By.id("form_street"));
        streetForm.sendKeys(streetName);

        WebElement houseNoForm = driver.findElement(By.id("form_number"));
        houseNoForm.sendKeys(houseNo);

        WebElement companyForm = driver.findElement(By.id("fos_user_registration_form_company_name"));
        companyForm.sendKeys(companyName);

        WebElement nipForm = driver.findElement(By.id("fos_user_registration_form_nip"));
        nipForm.sendKeys(nip);

        WebElement checkBox = driver.findElement(By.name(""));
        checkBox.click();

        WebElement registerButton = driver.findElement(By.id("register-submit-btn"));
        registerButton.click();
    }

    // Weryfikacja czy rejestracja się powiodła - logowanie
    @Test
    public void AssertRegistrationByLoggingIn() {
        String url = "https://men-men-s-01.codersguru.pl/";
        String password = "misiaczek100";
        String email = "firma@2p.pl";
        String firstName = "Adam";

        driver.get(url);
        WebElement linkLogin = driver.findElement(By.linkText("Zaloguj"));
        linkLogin.click();
//        WebElement linkLogin = driver.findElement(By.xpath("/html/body/section[1]/div/div[3]/a/button"));
//        linkLogin.click();
        WebElement emailForm = driver.findElement(By.id("username"));
        emailForm.sendKeys(email);
        WebElement passwordForm = driver.findElement(By.id("password"));
        passwordForm.sendKeys(password);
        WebElement loginButton = driver.findElement(By.id("_submit"));
        loginButton.submit();

        driver.get(url);
        WebElement login = driver.findElement(By.id("user-name"));
        String loggedName = login.getText();
        assertEquals(firstName, loggedName);
    }
}

///html/body/section[1]/div/div[3]/a/button