package com.company.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage {

    private final static String URL = "https://staging-web1.corp.globoforce.com/microsites/t/home?client=testclientclone3&setCAG=true";

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(id = "signIn-button")
    private WebElement loginButton;

    public LogInPage(WebDriver driver) {

        super(driver);
    }

    public boolean logInButtonDisplayed() {
        return isElementPresent(loginButton);
    }


    public LogInPage openURL() {
        driver.get(URL);
        return this;
    }


    public MainMenuPage loginToClientSite(String user, String pass) {
        username.sendKeys(user);
        password.sendKeys(pass);
        loginButton.click();
        return new MainMenuPage(getDriver());

    }


}
