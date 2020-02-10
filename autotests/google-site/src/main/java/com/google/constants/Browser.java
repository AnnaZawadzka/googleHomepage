package com.google.constants;

import com.google.common.collect.Maps;

import java.util.Map;

import static com.google.tools.PropertiesManager.getBrowserProperties;

public enum Browser {
    CHROME("chrome",
            getBrowserProperties().getProperty("chrome.webdriver.name"),
            getBrowserProperties().getProperty("chrome.webdriver.path")),
    FIREFOX("firefox",
            getBrowserProperties().getProperty("firefox.webdriver.name"),
            getBrowserProperties().getProperty("firefox.webdriver.path")),
    IE("ie",
            getBrowserProperties().getProperty("ie.webdriver.name"),
            getBrowserProperties().getProperty("ie.webdriver.path"));

    private String displayName;
    private String systemPropertyKey;
    private String driverLocation;

    Browser(String displayName, String systemPropertyKey, String driverLocation) {
        this.displayName = displayName;
        this.systemPropertyKey = systemPropertyKey;
        this.driverLocation = driverLocation;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getSystemPropertyKey() {
        return systemPropertyKey;
    }

    public String getDriverLocation() {
        return driverLocation;
    }

    private static final Map<String, Browser> displayNameIndex =
            Maps.newHashMapWithExpectedSize(Browser.values().length);

    static {
        for (Browser browser : Browser.values()) {
            displayNameIndex.put(browser.getDisplayName(), browser);
        }
    }

    public static boolean contains(String displayName) {
        return displayNameIndex.containsKey(displayName);
    }

    public static Browser lookupByDisplayName(String displayName) {
        return displayNameIndex.get(displayName);
    }

    public static final Browser DEFAULT_BROWSER =
            lookupByDisplayName(getBrowserProperties().getProperty("default.browser"));
}

