package com.company.test.pages.iafapps;

import com.company.test.pages.BasePage;
import com.company.test.pages.iafapps.configapp.ConfigappHomePage;
import com.company.test.services.logInServices.LogInToIafApp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextBlock;

public class IafHomePage extends BasePage {

    @Name("List of Applications")
    @FindBy(xpath = "//*[@class='drop']")
    private TextBlock otherApplicationDropDown;

    @Name("Config app link")
    @FindBy(xpath = "//a[@href='/iaf-config-app/']")
    private Link configappLink;

    @Name("Log out link")
    @FindBy(xpath="//*[@href='/iaf-login-app/home?logout']")
    private  Link logoutLink;

    public IafHomePage(WebDriver driver) {
        super(driver);
    }

    public ConfigappHomePage openConfigApp() {
        Actions action = new Actions(getDriver());
        action.moveToElement(otherApplicationDropDown).build().perform();
        waitElementToBeClickable(configappLink);
        configappLink.click();
        return new ConfigappHomePage(getDriver());
    }

    public LogInToIafApp logoutLink() {
        configappLink.click();
        return new LogInToIafApp(getDriver());
    }


}
