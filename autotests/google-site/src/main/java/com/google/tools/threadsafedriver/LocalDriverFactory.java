package com.google.tools.threadsafedriver;

import com.google.constants.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class LocalDriverFactory {
    private static final LocalDriverOptionsManager localDriverOptionsManager = new LocalDriverOptionsManager();

    public static synchronized WebDriver createDriver(Browser browser) {
        WebDriver driver;
        System.setProperty(browser.getSystemPropertyKey(), browser.getDriverLocation());
        switch (browser) {
            case CHROME:
                ChromeOptions chromeOptions = localDriverOptionsManager.getChromeOptions();
                driver = new ChromeDriver(chromeOptions);
                break;
            case FIREFOX:
                FirefoxOptions firefoxOptions = localDriverOptionsManager.getFirefoxOptions();
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case IE:
                InternetExplorerOptions internetExplorerOptions = localDriverOptionsManager.getInternetExplorerOptions();
                driver = new InternetExplorerDriver(internetExplorerOptions);
                break;
            default:
                throw new IllegalArgumentException("Unrecognized browser selected");
        }
        driver.manage().window().maximize();
        return driver;
    }
}
