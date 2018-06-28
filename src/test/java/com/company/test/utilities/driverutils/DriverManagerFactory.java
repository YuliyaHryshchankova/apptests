package com.company.test.utilities.driverutils;

public class DriverManagerFactory {

    public static DriverManager getManager(String browser) {
        DriverManager driverManager = null;
        if (browser.equalsIgnoreCase("chrome")) {
            driverManager = new Chrome();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driverManager = new Firefox();
        } else if (browser.equalsIgnoreCase("ie")) {
            driverManager = new Ie();
        }
        return driverManager;
    }
}
