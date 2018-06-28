package com.company.test.scenarios.remotedriver;

import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GloboforcePageTitleTest {

    private Logger logger = Logger.getLogger(getClass());

    @Test(description = "Check page title is correct")
    public void test() throws MalformedURLException {
        logger.info("Checking Globoforce title");
        DesiredCapabilities cap = new DesiredCapabilities();
        //cap.setBrowserName("firefox");
        cap.setBrowserName("chrome");
        cap.setPlatform(Platform.WINDOWS);
        URL url = new URL("http://10.6.126.13:4444/wd/hub");
        WebDriver driver = new RemoteWebDriver(url, cap);
        driver.get("https://www.globoforce.com/");
        Assert.assertEquals(driver.getTitle(), "Globoforce | Elevate Workplace Culture and Performance | Globoforce");
        driver.quit();

    }
}
