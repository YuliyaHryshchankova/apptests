package com.company.test.scenarios;

import com.company.test.utilities.DriverManager;
import com.company.test.utilities.DriverManagerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static final int IMPLICIT_TIMEOUT = 20;
    private DriverManager driverManager;
    protected static WebDriver driver;

    @Parameters("browser")

    //@BeforeClass(description = "Set up driver depending on browser")
    @BeforeSuite(description = "Set up driver depending on browser")
    public void startDriver(@Optional("firefox") String browser) {
        driverManager = DriverManagerFactory.getManager(browser);
        driver = driverManager.getInstance();
    }

    //@AfterClass(description = "Quit browser", alwaysRun = true)
    @AfterSuite(description = "Quit browser", alwaysRun = true)
    public void closeDriver() {
        if (driver != null)
            driver.quit();
    }

    protected WebDriver getDriver() {
        return this.driver;
    }

}
