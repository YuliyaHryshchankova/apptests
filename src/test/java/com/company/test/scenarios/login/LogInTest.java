package com.company.test.scenarios.login;

import com.company.test.pages.GDPRPage;
import com.company.test.pages.homepage.MainMenuPage;
import com.company.test.scenarios.BaseTest;
import com.company.test.services.logInServices.LogInToClientSite;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LogInTest extends BaseTest {

    private static final int IMPLICIT_TIMEOUT = 20;
    private String username = "E2029318";
    private String password = "password1";

    @Test(description = "Successful login", priority = 1)

    public void successLogin() {


        MainMenuPage mainMenuPage = new LogInToClientSite(driver)
                .openURL()
                .loginToClientSite(username, password);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        new GDPRPage(getWebDriver())
                .acceptGDPR();

        mainMenuPage
                .clickAcceptCookie();

        driver.manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);

        Assert.assertTrue(mainMenuPage.homeTabLocationDisplayed(), "Login Failed");
    }
}
