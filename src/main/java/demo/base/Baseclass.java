package demo.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Baseclass {
    public static WebDriver driver;

    // Method to launch the browser and load a given URL
    public static void browserLaunch(String url) throws IOException {
        // Fetch the download location from the config properties file
        String location = getPropertyFilevalue("DownloadLocation");
        File downloadDirectory = new File(location);

        // Set up the ChromeDriver for browser automation
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        // Set Chrome preferences for automatic file downloads to the specified directory
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadDirectory.getAbsolutePath());
        prefs.put("download.prompt_for_download", false);
        prefs.put("download.directory_upgrade", true);
        options.setExperimentalOption("prefs", prefs);

        // Disable popups and geolocation notifications
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-geolocation");

        // Set scaling options for the browser window
        options.addArguments("force-device-scale-factor=0.90");
        options.addArguments("high-dpi-support=0.90");

        // Initialize ChromeDriver with the specified options
        driver = new ChromeDriver(options);
        driver.get(url);
        driver.manage().window().maximize();
    }

    // ScenarioContext class to store scenario-specific data using ThreadLocal

    public class ScenarioContext {

        private static final ThreadLocal<Map<String, Object>> scenarioData = ThreadLocal.withInitial(HashMap::new);

        // Method to store a key-value pair in the context
        public static void set(String key, Object value) {
            scenarioData.get().put(key, value);
        }

        // Method to retrieve a value by key from the context
        public static Object get(String key) {
            return scenarioData.get().get(key);
        }

        // Method to clear all data from the context
        public static void clear() {
            scenarioData.get().clear();
        }
    }

    // Reusable Method to perform a click action using JavaScript Executor
    public static void javaScriptClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    // Reusable Method to perform a regular click action on a given WebElement
    public void click(WebElement element) {
        element.click();  // Click the element using WebDriver's click method
    }

    // Reusable Method to get the current project path
    public static String getProjectPath() {
        String property = System.getProperty("user.dir");
        return property;
    }

    // Reusable Method to retrieve a value from the config properties file
    public static String getPropertyFilevalue(String key) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(getProjectPath() + "/src/test/resources/Config.properties"));  // Load the config file
        Object object = properties.get(key);
        String string = (String) object;
        return string;
    }

    // Reusable Method for explicit wait on an element to be visible
    public static void explicitWait(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Reusable Method to capture and attach a screenshot
    public static void AttachScreenshot(String scenario) {
        TakesScreenshot Scrn = (TakesScreenshot) driver;
        byte[] data = Scrn.getScreenshotAs(OutputType.BYTES);
        Hookclass.scenario.attach(data, "image/png", "" + scenario);
    }

}