package com.company.test.utilities;

import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class Ie extends DriverManager {

    @Override
    protected void createWebDriver() {
        System.setProperty("webdriver.ie.driver", ".\\src\\test\\resources\\IEDriverServer.exe");
        driver = new InternetExplorerDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
}
