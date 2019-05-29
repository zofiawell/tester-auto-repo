import org.junit.After;
import org.junit.Before;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class CodersGuruLinksValidation {

    private WebDriver driver;

    @Before
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver","/home/zofia/tester-automat-kurs/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void CLose() {
        driver.quit();
    }

    // Sprawdzenie działania linka Cennik

    @Test
    public void ValidationCennik() {
        String url = "https://men-men-s-01.codersguru.pl/";
        driver.get(url);
        WebElement linkCennik = driver.findElement(By.xpath("//a[@href=\"/cennik\"]"));
        linkCennik.click();
        assertTrue(true);
        System.out.println("link 'Cennik' works.");
    }

    // Sprawdzenie działania linka Jak Działamy?

    @Test
    public void ValidationHow() {
        String url = "https://men-men-s-01.codersguru.pl/";
        driver.get(url);
        WebElement linkHow = driver.findElement(By.xpath("//a[@href=\"/#how-it-works\"]"));
        linkHow.click();
        assertTrue("Jak działamy?", true);
        System.out.println("link 'Jak działamy?' works.");

    }

    // Sprawdzenie działania linka Zostań Mentorem

    @Test
    public void ValidationMentor() {
        String url = "https://men-men-s-01.codersguru.pl/";
        driver.get(url);
        WebElement linkMentor = driver.findElement(By.linkText("Zostań Mentorem"));
        linkMentor.click();
        assertTrue(true);
        System.out.println("link 'Zostań Mentorem' works.");
    }

    // Sprawdzenie działania linka Zaloguj

    @Test
    public void ValidationLogin() {
        String url = "https://men-men-s-01.codersguru.pl/";
        driver.get(url);
        WebElement linkLogin = driver.findElement(By.linkText("Zaloguj"));
        linkLogin.click();
        assertTrue(true);
        System.out.println("link 'Zaloguj' works.");
    }

    // Sprawdzenie działania linka Coders Lab

    @Test
    public void ValidationCodersLab() {
        String url = "https://men-men-s-01.codersguru.pl/";
        driver.get(url);
        WebElement linkCodersLab = driver.findElement(By.linkText("Coders Lab"));
        linkCodersLab.click();
        assertTrue(true);
        System.out.println("link 'Coders Lab' works.");
    }

    // Sprawdzenie działania linka Coders Lab

    @Test
    public void ValidationFacebook() {
        String url = "https://men-men-s-01.codersguru.pl/";
        driver.get(url);
        WebElement linkFacebook = driver.findElement(By.xpath("/html/body/footer/div/div[2]/a"));
        linkFacebook.click();
        assertTrue(true);
        System.out.println("link 'Facebook' works.");
    }
}
