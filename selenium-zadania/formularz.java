import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class formularz {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/zofia/tester-automat-kurs/chromedriver");
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

        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getText().equals("Female")) {
                elements.get(i).click();
                break;
            }
        }
        for (WebElement element : elements) {
            if (element.getText().equals("Female")) {
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
        String message = driver.findElement(By.id("submit-msg")).getText();
        assertEquals("Successfully submitted!", message);


        System.out.println("Koniec");
    }

    @Test
    public void checkErrors() {
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
        driver.findElement(By.id("submit")).click();
//            List<String> listOfIds = getListOfIds();
        List<String> listOfIds = Arrays.asList("first-name", "last-name", "gender", "dob", "address", "email", "password", "company");
        int counter = 0;

        for (String elementLocator : listOfIds) {
            elementLocator = elementLocator + "-error";
            assertEquals("This field is required.", driver.findElement(By.id(elementLocator)).getText());
            counter++;
        }
        System.out.println(counter);
    }

//        System.out.println(elements.get(0).getText());
//        System.out.println(elements.get(1).getText());
//        System.out.println(elements.get(2).getText());
//
//        elements.get(0).click();


    private List<String> getListOfIds() {
        List<String> listID = new ArrayList<>();


        return listID;
    }


    @Test
    public void checkEmail() {
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
        driver.findElement(By.id("email")).sendKeys("w");
        driver.findElement(By.id("submit")).click();
        String message = driver.findElement(By.id("email-error")).getText();
        assertEquals("Please enter a valid email address.", message);

    }

    @Test
    public void checkName() {
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
        driver.findElement(By.id("first-name")).sendKeys("w");
        driver.findElement(By.id("submit")).click();
        String messageFirst = driver.findElement(By.id("first-name-error")).getText();
        assertEquals("Please enter a valid first name.", messageFirst);
        driver.findElement(By.id("last-name")).sendKeys("w");
        driver.findElement(By.id("submit")).click();
        String messageLast = driver.findElement(By.id("last-name-error")).getText();
        assertEquals("Please enter a valid last name.", messageLast);
        
       //rozdziel to na dwa testy, dla first-name i dla last-name, teraz będzie sytuacja, że jeśli assertEquals w linii 119
       //padnie to test nie pójdzie dalej
       // wszystkie Stringi do stałych
    }
}
