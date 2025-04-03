package demo.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Baseclass {

    public static WebDriver driver;

    //	 to load url
    public static void browserLaunch(String url) throws IOException {
        String location = getPropertyFilevalue("DownloadLocation");
        File downloadDirectory = new File(location);
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadDirectory.getAbsolutePath());
        prefs.put("download.prompt_for_download", false);
        prefs.put("download.directory_upgrade", true);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-geolocation");
        options.addArguments("force-device-scale-factor=0.90");
        options.addArguments("high-dpi-support=0.90");
        driver = new ChromeDriver(options);
        driver.get(url);
        driver.manage().window().maximize();
    }


    public class ScenarioContext {

        private static final ThreadLocal<Map<String, Object>> scenarioData = ThreadLocal.withInitial(HashMap::new);

        public static void set(String key, Object value) {
            scenarioData.get().put(key, value);
        }

        public static Object get(String key) {
            return scenarioData.get().get(key);
        }

        public static void clear() {
            scenarioData.get().clear();
        }
    }
    //javascriptclick
    public static void javaScriptClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }


    //    find elementid
    public static WebElement findElementID(String id) {
        WebElement element = driver.findElement(By.id(id));
        return element;
    }

    //	 find elementname
    public static WebElement findElementName(String name) {
        WebElement element = driver.findElement(By.name(name));
        return element;
    }

    public static List<WebElement> findElements(String xpath) {
        List<WebElement> elements = driver.findElements(By.xpath(xpath));
        return elements;
    }

    //	 find elementclassname
    public static WebElement findElementClassName(String data) {
        WebElement element = driver.findElement(By.id(data));
        return element;
    }

    //	 find elementxpath
    public static WebElement findElementXpath(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
        return element;
    }

    //	 sendkeys
    public static void sendKeys(WebElement element, String data) {
        element.sendKeys(data);
    }

    //	 gettext
    public String getText(WebElement element) {
        String string = element.getText();
        return string;
    }

    //	 select getoptions
    public List<WebElement> getOptions(WebElement element) {
        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        return options;
    }
// 	select using index

    public void selectIndex(WebElement element, int index) {

        Select select = new Select(element);
        select.selectByIndex(index);
    }

    //	 select using value
    public void selectValue(WebElement element, String value) {

        Select select = new Select(element);
        select.selectByValue(value);
    }

    // select using visible text
    public void selectVisibleText(WebElement element, String text) {

        Select select = new Select(element);
        select.selectByVisibleText(text);
    }
    //	 deselect all

    public void deselectAll(WebElement element) {

        Select select = new Select(element);
        select.deselectAll();
    }

    //  	 get first selected options
    public WebElement getFirstSelectedOptions(WebElement element) {

        Select select = new Select(element);
        WebElement selectedOption = select.getFirstSelectedOption();
        return selectedOption;
    }

//	get all selected options

    public List<WebElement> getAllSelectedOptions(WebElement element) {

        Select select = new Select(element);
        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        return selectedOptions;

    }

//	 navigate

    public void navigate(String url) {

        driver.navigate().to(url);
    }

    //   click
    public void click(WebElement element) {
          element.click();
    }

   //	close all windows
    public static void quit() {
        driver.quit();
    }


    //	 get title
    public String getTitle() {
        String title = driver.getTitle();
        return title;
    }

   //	 get the entered url
    public String getCurrentUrl() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl;
    }


    //	 Take Screenshot
    public static void takeScreenshot(String pathname) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File s = screenshot.getScreenshotAs(OutputType.FILE);
        File d = new File(pathname);
        FileUtils.copyFile(s, d);

    }

    //get current project path
    public static String getProjectPath() {
        String property = System.getProperty("user.dir");
        return property;
    }

    //get config file path
    public static String getPropertyFilevalue(String key) throws IOException {

        Properties properties = new Properties();
        properties.load(new FileInputStream(getProjectPath() + "/src/test/resources/Config.properties"));
        Object object = properties.get(key);
        String string = (String) object;
        return string;
    }


    //explicit wait
    public static void explicitWait(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    //attach screenshot
    public static void AttachScreenshot(String scenario) {
        TakesScreenshot Scrn = (TakesScreenshot) driver;
        byte[] data = Scrn.getScreenshotAs(OutputType.BYTES);
        Hookclass.scenario.attach(data, "image/png", "" + scenario);
    }






}
