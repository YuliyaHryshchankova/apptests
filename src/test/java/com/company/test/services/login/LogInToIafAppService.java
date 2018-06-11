package com.company.test.services.login;

import com.company.test.businessobjects.IafUser;
import com.company.test.pages.iafapps.IafAppLogInPage;
import org.openqa.selenium.WebDriver;

public class LogInToIafAppService {

    private WebDriver driver;

    private IafUser user = new IafUser();

    public LogInToIafAppService(WebDriver driver) {
        this.driver = driver;
    }

    public void logInToIafApp(String user, String password) {
        new IafAppLogInPage(driver)
                .openURL()
                .loginToIaf(user, password);
    }

    public void logInToIafApp(IafUser iafUser) {
        logInToIafApp(iafUser.getUsername(), iafUser.getPassword());
    }

}
