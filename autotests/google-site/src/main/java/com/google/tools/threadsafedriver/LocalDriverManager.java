package com.google.tools.threadsafedriver;

import com.google.constants.Browser;
import com.google.constants.Environment;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.String.*;

public class LocalDriverManager {
    private static Environment environment = null;
    private static InheritableThreadLocal<WebDriver> webDriverThreadHolder = new InheritableThreadLocal<>();
    private static final Logger LOGGER = LoggerFactory.getLogger(LocalDriverManager.class);

    public static void tearDown() {
        cleanCookies();
        getDriver().quit();
        webDriverThreadHolder.remove();
    }

    public static WebDriver getDriver() {
        return webDriverThreadHolder.get();
    }

    private static void setWebDriver(WebDriver driver) {
        webDriverThreadHolder.set(driver);
    }

    public static Environment getEnvironment() {
        return environment;
    }

    public static void setEnvironment(Environment environment) {
        LocalDriverManager.environment = environment;
    }

    public static void setDriver(Browser browser, Environment environment) {
        try {
            WebDriver webDriver = LocalDriverFactory.createDriver(browser);
            setWebDriver(webDriver);
            setEnvironment(environment);
        } catch (Exception e) {
            LOGGER.info(format("During driver preparation error occured: %s", e));
        }
    }

    public static void cleanCookies() {
        getDriver().manage().deleteAllCookies();
    }
}
