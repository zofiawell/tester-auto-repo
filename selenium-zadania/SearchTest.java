import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class SearchTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","/home/zofia/tester-automat-kurs/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void searchTest() {
        driver.get("http://www.google.com");
        WebElement input = driver.findElement(By.name("q"));
        input.sendKeys("Testowanie Selenium");
        input.submit();

        String title = driver.getTitle();
        System.out.println(title);

        assertEquals("Testowanie Selenium - Szukaj w Google", title);
        //String powyżej powinien być wyekstraktowany do stałej
    }
}
