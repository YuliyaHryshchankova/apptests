package com.company.test.scenarios.login;

import com.company.test.pages.LogInPage;
import com.company.test.pages.homepage.RightTopMenuPage;
import com.company.test.scenarios.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogOutTest extends BaseTest {

    @Test(description = "Successful logout", priority = 5)
    public void successLogOut() {
        logger.info("Verify log out from client site");

        LogInPage logInPage = new RightTopMenuPage(driver)
                .clickLogOutLink();

         Assert.assertTrue(logInPage.logInButtonDisplayed(), "Logout Failed");
    }
}
