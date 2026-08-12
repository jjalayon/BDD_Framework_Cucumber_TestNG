package StepDefinitions;

import driver.DriverManager;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginPageStepDef {

    private WebDriver driver;
    private LoginPage loginPage;
    private ConfigReader configReader;

    public LoginPageStepDef() {
        this.driver = DriverManager.getDriver("chrome");
        this.loginPage = new LoginPage(driver);
        this.configReader = ConfigReader.getInstance();
    }


    @Given("that User is on the login page")
    public void thatUserIsOnTheLoginPage() {
        // Write code here that turns the phrase above into concrete actions
        String baseUrl = configReader.getProperty("base.url");
        driver.get(baseUrl);
    }

    @When("user enters username {string}")
        // Write code here that turns the phrase above into concrete actions
    public void user_enters_username(String username) {
        loginPage.enterUserName(username);
    }

    @When("user enters password {string}")
    public void user_enters_password(String password) {
        // Write code here that turns the phrase above into concrete actions
        loginPage.enterPassword(password);
    }

    @And("user clicks the Login Button")
    public void user_clicks_the_login_button()  {
        // Write code here that turns the phrase above into concrete actions
        loginPage.clickLogin();
    }

    @Then("user should be navigated to Item list page")
    public void user_should_be_navigated_to_item_list_page(){
        // Write code here that turns the phrase above into concrete actions
        String welcomeMessage = loginPage.getWelcomeMessage();
        Assert.assertFalse(welcomeMessage.isEmpty(), "Welcome message is not displayed");
    }

    @Then("error message should be visible")
    public void errorMessageShouldBeVisible() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
    }

    @And("error message should be {string}")
    public void errorMessageShouldBe(String expectedText) {
        // Write code here that turns the phrase above into concrete actions
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(actualErrorMessage.contains(expectedText),
                "Expected error message to contain: " + expectedText + ", but got: " + actualErrorMessage);
    }
}
