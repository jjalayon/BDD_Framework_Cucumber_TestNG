package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * TestNG Cucumber Runner
 */
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"StepDefinitions"},
        //tags = "@smoke or @regression",
        plugin = {
                "pretty",
                "json:cucumber.json"
        },
        monochrome = true,
        dryRun = false
)
public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {
    // This class will be empty as AbstractTestNGCucumberTests handles the execution
}