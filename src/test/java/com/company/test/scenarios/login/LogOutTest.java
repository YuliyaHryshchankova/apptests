package com.company.test.scenarios.login;

import com.company.test.pages.LogInPage;
import com.company.test.pages.homepage.RightTopMenuPage;
import com.company.test.scenarios.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogOutTest extends BaseTest {

    @Test(description = "Successful logout", priority = 4)
    public void successLogOut() {

        LogInPage logInPage = new RightTopMenuPage(driver)
                .clickLogOutLink();

        Assert.assertTrue(logInPage.logInButtonDisplayed(), "Logout Failed");
    }
}
