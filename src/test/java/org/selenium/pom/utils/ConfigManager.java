package org.selenium.pom.utils;

import org.selenium.pom.constants.EnvType;

import java.util.Properties;

public class ConfigManager {
    private final Properties properties;
    private static ConfigManager configManager;

    private ConfigManager() {
        String env = System.getProperty("env", String.valueOf(EnvType.STAGE));
        switch (EnvType.valueOf(env)) {
            case STAGE:
                properties = PropertyUtils.propertyloader("src/test/resources/stg_config.properties");
                break;
            case PROD:
                properties = PropertyUtils.propertyloader("src/test/resources/prod_config.properties");
                break;
            default:
                throw new RuntimeException("Unable to get env");
        }

    }

    public static ConfigManager getInstance() {
        if (configManager == null) {
            configManager = new ConfigManager();
        }
        return configManager;
    }

    public String getbaseUrl() {
        String prop = properties.getProperty("baseUrl");
        if (prop != null) {
            return prop;
        } else {
            throw new RuntimeException("Unable to get base url");
        }


    }

    public String getUsername() {
        String prop = properties.getProperty("userName");
        if (prop != null)
            return prop;
        else
            throw new RuntimeException("Unable to get username");
    }

    public String getPassword() {
        String prop = properties.getProperty("password");
        if (prop != null) {
            return prop;
        } else {
            throw new RuntimeException("Unable to get password");
        }
    }
}