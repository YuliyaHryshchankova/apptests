package com.company.test.utilities.driverutils;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Firefox extends DriverManager {

    @Override
    protected void createWebDriver() {
        System.setProperty("webdriver.gecko.driver", ".\\src\\test\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
}
