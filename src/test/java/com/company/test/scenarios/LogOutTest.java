package com.company.test.scenarios;

import com.company.test.pages.LogInPage;
import com.company.test.pages.homepage.RightTopMenuPage;
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
