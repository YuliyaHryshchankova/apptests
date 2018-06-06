package com.company.test.services.logInServices;

import com.company.test.pages.BasePage;
import com.company.test.pages.iafapps.IafHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class LogInToIafApp extends BasePage {

    private static final String URL =
            "https://staging-sandbox0.corp.globoforce.com/iaf-login-app/home";

    @Name("Username Input field")
    @FindBy(name = "j_username")
    private TextInput username;

    @Name("Password Input field")
    @FindBy(name = "j_password")
    private TextInput password;

    @Name("Login button")
    @FindBy(xpath = "//*[@class='button']")
    private Button loginButton;

    public LogInToIafApp(WebDriver driver) {

        super(driver);
    }

    public boolean logInButtonDisplayed() {
        return isElementPresent(loginButton);
    }

    public LogInToIafApp openURL() {
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
