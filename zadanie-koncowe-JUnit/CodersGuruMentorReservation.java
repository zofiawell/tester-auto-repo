import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.*;

public class CodersGuruMentorReservation {

    private WebDriver driver;

    @Before
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "/home/zofia/tester-automat-kurs/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void CLose() {
        driver.quit();
    }

    // Założenie konta prywatnego

    @Test
    public void RegisterNewAccount() {


        // Dane testowe
        String url = "https://men-men-s-01.codersguru.pl/";
        String password = "misiaczek100";
        String email = "prywatny@2p.pl";
        String firstName = "Anna";
        String lastName = "Kowalska";
        String cityName = "Poznań";
        String postalCode = "60-000";
        String streetName = "Liliowa";
        String houseNo = "1";

        // Rejestracja konta
        driver.get(url);
        WebElement linkRegister = driver.findElement(By.cssSelector("input.link"));
        linkRegister.click();

        WebElement buttonPerson = driver.findElement(By.id("person"));
        buttonPerson.click();

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
        String email = "prywatny@2p.pl";
        String firstName = "Anna";

        driver.get(url);
        WebElement linkLogin = driver.findElement(By.linkText("Zaloguj"));
        linkLogin.click();

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

    @Test
    public void FindMentor() {

        // Dane testowe
        String url = "https://men-men-s-01.codersguru.pl/";
        String topic = "AJAX";
        String password = "misiaczek100";
        String email = "prywatny@2p.pl";

        //Logowanie
        driver.get(url);
        WebElement linkLogin = driver.findElement(By.linkText("Zaloguj"));
        linkLogin.click();

        WebElement emailForm = driver.findElement(By.id("username"));
        emailForm.sendKeys(email);

        WebElement passwordForm = driver.findElement(By.id("password"));
        passwordForm.sendKeys(password);

        WebElement loginButton = driver.findElement(By.id("_submit"));
        loginButton.submit();

        //Wybór mentora
        WebElement topicDropdown = driver.findElement(By.className("select-text-desktop"));
        topicDropdown.click();

        WebElement topicWindow = driver.findElement(By.xpath("//li[text()='AJAX']"));
        topicWindow.click();

        WebElement findMentorButton = driver.findElement(By.cssSelector("input.link"));
        findMentorButton.click();

        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

        driver.get(currentUrl);

        // Rezerwacja daty i godziny mentora
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//button[text() = 'Rezerwuj']"), 0));

        WebElement reservationButton = driver.findElements(By.xpath("//button[text() = 'Rezerwuj']")).get(0);
        reservationButton.click();

        WebDriverWait waitDate = new WebDriverWait(driver, 2);
        WebElement date = waitDate.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text() = '31.05']")));
        date.click();

        WebElement reservationDate = driver.findElement(By.xpath("//li[text() = '31.05']"));
        reservationDate.click();

        WebDriverWait waitTime = new WebDriverWait(driver, 2);
        WebElement time = waitTime.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text() = '20:00']")));
        time.click();

        WebElement reservationTime = driver.findElement(By.xpath("//li[text() = '20:00']"));
        reservationTime.click();

        String reservationDetails = driver.findElement(By.id("sumary-date")).getText();
        assertEquals("31.05.2019, 20:00", reservationDetails);

        WebElement notesField = driver.findElement(By.name("name"));
        notesField.sendKeys("Mam problem");

        WebElement buttonPay = driver.findElement(By.cssSelector(".reservation-modal__summary-button"));
        buttonPay.click();

        WebDriverWait waitPayU = new WebDriverWait(driver, 5);
        waitPayU.until(ExpectedConditions.titleIs("PayU"));

        String titlePayU = driver.getTitle();
        assertEquals("PayU", titlePayU);

        String currentUrlPayU = driver.getCurrentUrl();
        System.out.println(currentUrlPayU);

        driver.get(currentUrlPayU);




    }


}



//*[@id="sumary-date"]