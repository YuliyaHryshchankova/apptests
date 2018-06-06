package com.company.test.services.logInServices;

import com.company.test.pages.BasePage;
import com.company.test.pages.homepage.MainMenuPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class LogInToClientSite extends BasePage {

    private final static String URL = "https://staging-web1.corp.globoforce.com/microsites/t/home?client=testclientclone3&setCAG=true";

    @Name("Username input field")
    @FindBy(name = "username")
    private TextInput usernameTextInput;

    @Name("Password input field")
    @FindBy(name = "password")
    private TextInput passwordTextInput;

    @Name("Sign in button")
    @FindBy(id = "signIn-button")
    private Button loginButton;

    public LogInToClientSite(WebDriver driver) {

        super(driver);
    }

    public boolean logInButtonDisplayed() {
        return isElementPresent(loginButton);
    }


    public LogInToClientSite openURL() {
        driver.get(URL);
        return this;
    }


    public MainMenuPage loginToClientSite(String user, String pass) {
        usernameTextInput.sendKeys(user);
        passwordTextInput.sendKeys(pass);
        loginButton.click();
        return new MainMenuPage(getDriver());

    }
}
