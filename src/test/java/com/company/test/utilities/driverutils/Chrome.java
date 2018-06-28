package com.company.test.utilities.driverutils;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Chrome extends DriverManager {

    @Override
    protected void createWebDriver() {
        System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

}
