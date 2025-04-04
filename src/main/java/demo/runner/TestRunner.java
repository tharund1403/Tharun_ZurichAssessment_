package demo.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

// JUnit to run the tests using the Cucumber class
@RunWith(Cucumber.class)
@CucumberOptions
        // The path location of the feature files
        (features = "src/test/resources/features",
                glue = {"demo.stepdefinition", "demo.base"},
                monochrome = true,
                plugin = {"pretty", "html:target/cucumber-reports/cucumber-reports.html",
                        "json:target/cucumber-reports/cucumber-reports.json"},
                tags = "@Demo",
                dryRun = false

        )

public class TestRunner {
}

































