package com.company.test.scenarios.login;

import com.company.test.businessobjects.ClientSiteUser;
import com.company.test.scenarios.BaseTest;
import com.company.test.services.login.LogInToClientSiteService;
import com.company.test.staticfactory.UsersStaticFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {

    LogInToClientSiteService logInToClientSiteService;

    @Test(description = "Successful login", priority = 1)
    public void successLogin() {
        ClientSiteUser clientSiteUser = UsersStaticFactory.createDefaultClientSiteUser();
        logInToClientSiteService = new LogInToClientSiteService(driver);
        logInToClientSiteService.login(clientSiteUser);

        Assert.assertTrue(logInToClientSiteService.homeTabLocationDisplayed(), "Login Failed");
    }
}
