package com.company.test.pages.iafapps.configapp;

import com.company.test.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfigappHomePage extends BasePage {

    @FindBy(xpath = "//a[@href='/iaf-config-app/siteSettingsOpen?client=5021&menuid=2_1']")
    private WebElement client;

    public ConfigappHomePage(WebDriver driver) {
        super(driver);
    }

    public ConfigappCoreSettingsPage clickClientLink() {
        // WebElement clientLink = getDriver().findElement(By.linkText(clientName));
        waitElementToBeClickable(client);
        client.click();
        return new ConfigappCoreSettingsPage(getDriver());
    }

}
