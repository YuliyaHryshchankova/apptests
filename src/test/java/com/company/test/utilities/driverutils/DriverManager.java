package com.company.test.utilities.driverutils;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    protected static final int IMPLICIT_TIMEOUT = 20;
    protected WebDriver driver;

    protected abstract void createWebDriver();

    public WebDriver getInstance() {
        if (null == driver) {
            createWebDriver();
        }
        return driver;
    }
}
