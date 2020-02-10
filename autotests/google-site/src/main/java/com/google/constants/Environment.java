package com.google.constants;

import com.google.common.collect.Maps;
import com.google.tools.PropertiesManager;

import java.util.Map;

import static com.google.tools.PropertiesManager.getEnvironmentProperties;

public enum Environment {
    PROD(PropertiesManager.getEnvironmentProperties().getProperty("prod.env.url"));

    private String baseUrl;

    Environment(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    private static final Map<String, Environment> nameIndex =
            Maps.newHashMapWithExpectedSize(Environment.values().length);

    static {
        for (Environment environment : Environment.values()) {
            nameIndex.put(environment.name(), environment);
        }
    }

    public static boolean contains(String name) {
        return nameIndex.containsKey(name);
    }

    public static Environment lookupByName(String name) {
        return nameIndex.get(name);
    }

    public static final Environment DEFAULT_ENVIRONMENT =
            lookupByName(getEnvironmentProperties().getProperty("default.environment"));
}

