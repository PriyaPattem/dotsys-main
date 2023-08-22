package org.selenium.pom.factory;

import org.selenium.pom.constants.DriverType;

public class DriverManagerFactory {
    public static DriverManager getDriverFactory(DriverType driverType){
        switch (driverType){
            case CHROME:
                return new ChromeDriverManager();
            case FIREFOX:
                return new FireFoxDriverManager();
            case EDGE:
                return new EdgeDriverManager();
            default:
                throw new IllegalStateException("Not provided proper driver type");

        }

    }
}