package com.google.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

import static java.lang.String.*;

public class PropertiesManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesManager.class);
    private static final String ENVIRONMENT_PROPERTIES_PATH = "properties/environment.properties";
    private static final String BROWSER_PROPERTIES_PATH = "properties/browser.properties";

    private static Properties environmentProperties = loadProperties(ENVIRONMENT_PROPERTIES_PATH);
    private static Properties browserProperties = loadProperties(BROWSER_PROPERTIES_PATH);

    private static Properties loadProperties(String propertiesPath) {
        Properties properties = new Properties();

        try {
            properties.load(PropertiesManager.class.getClassLoader().getResourceAsStream(propertiesPath));
        } catch (IOException e) {
            LOGGER.error(format("Error while %s loading", propertiesPath));
        }

        return properties;
    }

    public static Properties getEnvironmentProperties() {
        return environmentProperties;
    }

    public static Properties getBrowserProperties() {
        return browserProperties;
    }
}
