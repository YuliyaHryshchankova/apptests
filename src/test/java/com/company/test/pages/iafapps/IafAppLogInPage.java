package com.company.test.pages.iafapps;

import com.company.test.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class IafAppLogInPage extends BasePage {

    private static final String URL =
            "https://staging-sandbox0.corp.globoforce.com/iaf-login-app/home";

    @Name("Username Input field")
    @FindBy(name = "j_username")
    private TextInput usernameTextInput;

    @Name("Password Input field")
    @FindBy(name = "j_password")
    private TextInput passwordTextInput;

    @Name("Login button")
    @FindBy(xpath = "//*[@class='button']")
    private Button loginButton;

    public IafAppLogInPage(WebDriver driver) {
        super(driver);
    }

    public boolean logInButtonDisplayed() {
        return isElementPresent(loginButton);
    }

    public IafAppLogInPage openURL() {
        driver.get(URL);
        return this;
    }

    public IafHomePage loginToIaf(String user, String password) {
        usernameTextInput.sendKeys(user);
        passwordTextInput.sendKeys(password);
        loginButton.click();
        return new IafHomePage(getDriver());
    }


}



