package com.google.tools.threadsafedriver;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class LocalDriverOptionsManager {
    ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("ignore-certificate-errors");
        options.addArguments("disable-features=RendererCodeIntegrity");
        return options;
    }

    FirefoxOptions getFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        options.setCapability(FirefoxDriver.PROFILE, profile);
        return options;
    }

    InternetExplorerOptions getInternetExplorerOptions() {
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.destructivelyEnsureCleanSession();
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
        options.enablePersistentHovering();
        options.ignoreZoomSettings();
        options.disableNativeEvents();
        return options;
    }
}
