package StepDefinitions;

import driver.DriverManager;
import utils.LoggerUtilities;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utils.ScreenshotUtil;

/**
 * Cucumber Hooks for setup and teardown
 */
public class Hooks {

    private WebDriver driver;
    private LoggerUtilities logger = LoggerUtilities.getInstance();

    @Before
    public void setUp(Scenario scenario) {
        logger.info("Starting scenario: " + scenario.getName());
        driver = DriverManager.getDriver("chrome");
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            logger.error("Scenario failed: " + scenario.getName());
            String screenshot = ScreenshotUtil.getBase64Screenshot(driver);
            scenario.attach(screenshot.getBytes(), "image/png", scenario.getName());
        }

        logger.info("Completed scenario: " + scenario.getName());
        DriverManager.quitDriver();
    }
}
