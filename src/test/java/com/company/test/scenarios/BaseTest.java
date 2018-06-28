package com.company.test.scenarios;

import com.company.test.utilities.CustomListener;
import com.company.test.utilities.ScreenshotUtils;
import com.company.test.utilities.driverutils.DriverManager;
import com.company.test.utilities.driverutils.DriverManagerFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

@Listeners(CustomListener.class)
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

    @AfterMethod
    public void takeScreenshot(ITestResult result) {
        ScreenshotUtils.captureScreenshot(driver, result);
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

    protected Logger logger = Logger.getLogger(getClass());

}
