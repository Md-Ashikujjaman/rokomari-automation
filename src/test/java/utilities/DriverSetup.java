package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class DriverSetup {

    private static String browser_name = System.getProperty("browser", "chrome");

    private static final ThreadLocal<WebDriver>DRIVER_THREAD_LOCAL = new ThreadLocal<>();

    public static void setDriver(WebDriver driver){
        DriverSetup.DRIVER_THREAD_LOCAL.set(driver);
    }
    public static WebDriver getDriver(){
        return DRIVER_THREAD_LOCAL.get();
    }

    public WebDriver driver;

    @BeforeSuite
    public void startBrowser(){
        WebDriver driver = getBrowser(browser_name);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        setDriver(driver);
        driver.manage().window().maximize();
    }

    public WebDriver getBrowser(String name){
        if (name.equalsIgnoreCase("Edge"))
            return new EdgeDriver();
        else if (name.equalsIgnoreCase("chrome"))
            return new ChromeDriver();
        else if (name.equalsIgnoreCase("firefox"))
            return new FirefoxDriver();
        else {
            throw new RuntimeException("Browser is not available with the given name: " + name);
        }
    }

    @AfterSuite
    public void closeBrowser(){
        getDriver().quit();
    }
}

