package com.company.test.pages.iafapps;

import com.company.test.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IafLoginPage extends BasePage {

    private static final String URL =
            "https://staging-sandbox0.corp.globoforce.com/iaf-login-app/home";

    @FindBy(name = "j_username")
    private WebElement username;

    @FindBy(name = "j_password")
    private WebElement password;

    @FindBy(xpath = "//*[@class='button']")
    private WebElement loginButton;

    public IafLoginPage(WebDriver driver) {

        super(driver);
    }

    public boolean logInButtonDisplayed() {
        return isElementPresent(loginButton);
    }

    public IafLoginPage openURL() {
        driver.get(URL);
        return this;
    }


    public IafHomePage loginToIaf(String user, String pass) {
        username.sendKeys(user);
        password.sendKeys(pass);
        loginButton.click();
        return new IafHomePage(getDriver());

    }


}
