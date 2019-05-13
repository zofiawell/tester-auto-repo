import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class formularz {

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
    public void fillForm() {
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
        driver.findElement(By.id("first-name")).sendKeys("Karol");
        driver.findElement(By.id("last-name")).sendKeys("Kowalski");
        List<WebElement> elements = driver.findElements(By.cssSelector(".radio-inline"));

        for(int i=0; i < elements.size(); i++) {
            if (elements.get(i).getText().equals("Female")) {
                elements.get(i).click();
                break;
            }
        }
        for (WebElement element : elements) {
            if (element.getText().equals("Female")){
                element.click();
                break;
            }
        }
        driver.findElement(By.id("dob")).sendKeys("05/22/2010");
        driver.findElement(By.id("address")).sendKeys("Prosta 51");
        driver.findElement(By.id("email")).sendKeys("karol.kowalski@mailinator.com");
        driver.findElement(By.id("password")).sendKeys("Pass123");
        driver.findElement(By.id("company")).sendKeys("CodersLab");
        Select roleDropdown = new Select(driver.findElement(By.name("role")));
        roleDropdown.selectByVisibleText(("Manager"));
        Select jobDropdown = new Select(driver.findElement(By.name("expectation")));
        jobDropdown.selectByVisibleText(("High salary"));

        driver.findElement(By.xpath("//label[text()= 'Read books']")).click();
        driver.findElement(By.xpath("//label[text()= 'Join tech cons']")).click();
        driver.findElement(By.id("comment")).sendKeys("To jest mój pierwszy automat testowy");
        driver.findElement(By.id("submit")).click();

        System.out.println("Koniec");




//        System.out.println(elements.get(0).getText());
//        System.out.println(elements.get(1).getText());
//        System.out.println(elements.get(2).getText());
//
//        elements.get(0).click();

    }
}
