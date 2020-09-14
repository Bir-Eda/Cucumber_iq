package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver ldriver;

    public LoginPage(WebDriver driver) {  // bu constructor parametreli oldugu icin step defs te obje yazinca parametreliyapicaz ve driver ldriver a esit olacak
        ldriver = driver;
        PageFactory.initElements((WebDriver) ldriver, this);
    }

    @FindBy(how = How.XPATH, using = "//input[@id='Email']")
    WebElement txtEmail;

    @FindBy(how = How.XPATH, using = "//input[@id='Password']")
    WebElement txtPassword;

    @FindBy(how = How.XPATH, using = "//input[@value='Log in']")
    WebElement loginButton;

    @FindBy(how = How.LINK_TEXT, using = "Logout")
    WebElement logoutButton;

    // webelementleri stepdefs te kullanabilmek icin metod yapmamiz lazim

    public void enterCredentials(String email, String password) {
        txtEmail.clear();
        txtEmail.sendKeys(email);

        txtPassword.clear();
        txtPassword.sendKeys(password);

    }

    public void clickLogin() {
        loginButton.click();
    }

    public void clickLogout() {
        logoutButton.click();
    }
}