package com.darksky.base;

import com.darksky.utils.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class BasePage {
    static public WebDriver driver;

    public static WebDriver initDriver() {
        ConfigReader.readProperties(Constants.CONFIGURATION_FILE);
        String browser = ConfigReader.getProperty("browser");
        String baseUrl = ConfigReader.getProperty("url");
        switch (browser){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid Browser name");
        }
        PageManager.initialize();
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        driver.get(baseUrl);
        return driver;
    }

    public static void tearDown(){
        if (driver != null) {
            driver.quit();
        }else {
            throw new RuntimeException("Driver is null");
        }
    }
}
