package com.company.test.scenarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static WebDriver driver;

    protected static final int IMPLICIT_TIMEOUT = 20;

    @Parameters("browser")

    //@BeforeClass(description = "Set up driver depending on browser")
    @BeforeSuite(description = "Set up driver depending on browser")
    public void startDriver(@Optional("firefox") String browser) {
        if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", ".\\src\\test\\resources\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", ".\\src\\test\\resources\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    //@AfterClass(description = "Quit browser", alwaysRun = true)
    @AfterSuite(description = "Quit browser", alwaysRun = true)
    public void closeDriver() {
        if (driver != null)
            driver.quit();
    }

    protected WebDriver getWebDriver() {
        return this.driver;
    }

}
