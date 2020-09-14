package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pagefactory.LoginPage;

public class LoginDefs {
    WebDriver driver;
    LoginPage loginPage;

    @Given("User launch chrome browser")
    public void user_launch_chrome_browser() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        loginPage=new LoginPage(driver);
    }
    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        driver.get(url);
    }
    @When("User enters email as {string} and password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) {
         loginPage.enterCredentials(email, password);

    }
    @When("User clicks on login")
    public void user_clicks_on_login() {
        loginPage.clickLogin();



    }
    @Then("Page title should be {string}")
    public void page_title_should_be(String title) {
        String expectedTitle= title;
         String actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);


    }
    @When("User clicks on logout link")
    public void user_clicks_on_logout_link() {
        loginPage.clickLogout();


    }
    @Then("Close the browser")
    public void close_the_browser() {
       driver.quit();

    }

}