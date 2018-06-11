package com.company.test.services.loginservices;

import com.company.test.businessobjects.ClientSiteUser;
import com.company.test.pages.GDPRPage;
import com.company.test.pages.LogInPage;
import com.company.test.pages.homepage.MainMenuPage;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LogInToClientSiteService {

    private static final int IMPLICIT_TIMEOUT = 20;
    private WebDriver driver;

    public LogInToClientSiteService(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String user, String password) {

        MainMenuPage mainMenuPage =      new LogInPage(driver)
                .openURL()
                .loginToClientSite(user, password);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        new GDPRPage(getDriver())
                .acceptGDPR();

        mainMenuPage
                .clickAcceptCookie();

        driver.manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
    }

    public void login(ClientSiteUser clientSiteUser) {
        login(clientSiteUser.getUsername(), clientSiteUser.getPassword());
    }

    public boolean logInButtonDisplayed() {
        return new MainMenuPage(this.driver).homeTabLocationDisplayed();
    }

    protected WebDriver getDriver() {
        return this.driver;
    }

}
