package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class MyStepdefs {

    private WebDriver driver;

    @Given("open browser with url Coders Guru")
    public void openBrowserWithUrlCodersGuru() {
        System.setProperty("webdriver.chrome.driver", "/home/zofia/tester-automat-kurs/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://men-men-s-01.codersguru.pl/");

    }

    @When("user clicks registration button")
    public void userClicksRegistrationButton() {
        WebElement linkRegister = driver.findElement(By.cssSelector("input.link"));
        linkRegister.click();
    }


    @Then("user is in registration page")
    public void userIsInRegistrationPage() {
        String currentUrl = driver.getCurrentUrl();
        assertEquals("https://men-men-s-01.codersguru.pl/register/", currentUrl);

    }

    @When("user fills all mandatory id fields with data")
    public void userFillsAllMandatoryIdFieldsWithData(DataTable values) {
        List<List<String>> listsOfValues = values.asLists();
        System.out.println(listsOfValues);

        for (List<String> list : listsOfValues) {
            WebElement listId = driver.findElement(By.id(list.get(0)));
            listId.sendKeys(list.get(1));

        }

    }


    @And("user clicks rules checkbox and submittes the form")
    public void userClicksRulesCheckboxAndSubmittesTheForm() {
        WebElement checkBox = driver.findElement(By.name(""));
        checkBox.click();
        WebElement registerButton = driver.findElement(By.id("register-submit-btn"));
        registerButton.click();
    }

    @Then("new private account is created")
    public void newPrivateAccountIsCreated() {
        WebElement loggedUserName = driver.findElement(By.id("user-name"));
        String loggedUserNameText = loggedUserName.getText();
        assertEquals("Karol", loggedUserNameText);


    }
}