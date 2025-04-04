package demo.base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import java.io.IOException;

public class Hookclass extends Baseclass {

    // Declare a static Scenario object to store the current scenario details
    public static Scenario scenario;

    // This method is executed before each scenario starts.
    // It launches the browser and navigates to the URL fetched from the config file.
    @Before
    public void browserLaunch(Scenario scenario) throws IOException {
        this.scenario = scenario;
        browserLaunch(getPropertyFilevalue("URL"));
    }

    // This method is executed after each scenario ends.
    // It handles the teardown operations, including capturing screenshots if the scenario fails.
    @After
    public void tearDown() {
        // Check if the scenario has failed
        if (scenario.isFailed()) {
            // Attach a screenshot to the report with the status of the scenario
            AttachScreenshot("Status: " + scenario.getStatus());
        }
        // Close the browser and quit the WebDriver session
        driver.quit();
    }

}
