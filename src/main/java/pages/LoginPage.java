package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object for Login Page
 */
public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Login Page Element locators
     */
    @FindBy(id = "user-name")
    private WebElement userNameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//h3")
    private WebElement errorMessage;

    @FindBy(xpath = "//span[@data-test='title']")
    private WebElement welcomeMessage;

    /**
     * Login Page Methods
     */

    public void enterUserName(String username){
        type(userNameField, username);
    }

    public void enterPassword(String password){
        type(passwordField, password);
    }

    public void clickLogin() {
        click(loginButton);
    }

    /**
     * Complete login with username and password
     */
    public void login(String username, String password) {
        enterUserName(username);
        enterPassword(password);
        clickLogin();
    }

    /**
     * Check if error message is displayed
     */
    public boolean isErrorMessageDisplayed() {
        return isDisplayed(errorMessage);
    }

    /**
     * Get error message text
     */
    public String getErrorMessage() {
        return getText(errorMessage);
    }

    /**
     * Check if login was successful
     */
    public boolean isLoginSuccessful() {
        return isDisplayed(welcomeMessage);
    }

    /**
     * Get welcome message
     */
    public String getWelcomeMessage() {
        return getText(welcomeMessage);
    }

}
