package com.company.test.pages.iafapps;

import com.company.test.pages.BasePage;
import com.company.test.pages.iafapps.configapp.ConfigappHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class IafHomePage extends BasePage {

    @FindBy(xpath = "//*[@class='drop']")
    private WebElement otherApplicationDropDown;

    @FindBy(xpath = "//a[@href='/iaf-config-app/']")
    private WebElement configappLink;

    @FindBy(xpath="//*[@href='/iaf-login-app/home?logout']")
    private  WebElement logoutLink;

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

    public IafLoginPage logoutLink() {
        configappLink.click();
        return new IafLoginPage(getDriver());
    }


}
