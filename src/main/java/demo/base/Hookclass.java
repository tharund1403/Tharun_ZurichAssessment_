package demo.base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;

public class Hookclass extends Baseclass {
    public static Scenario scenario;

    @Before
    public void browserLaunch(Scenario scenario) throws IOException {
        this.scenario = scenario;
        browserLaunch(getPropertyFilevalue("URL"));
    }


    @After
    public void tearDown() {
        if (scenario.isFailed()) {
                  AttachScreenshot("Status: " + scenario.getStatus());
        }
        driver.quit();
    }

}
