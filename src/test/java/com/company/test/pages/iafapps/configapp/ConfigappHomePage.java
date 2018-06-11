package com.company.test.pages.iafapps.configapp;

import com.company.test.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfigappHomePage extends BasePage {

    public ConfigappHomePage(WebDriver driver) {
        super(driver);
    }

    public ConfigappCoreSettingsPage clickClientLink(String clientName) {
        WebElement clientLink = getDriver().findElement(By.linkText(clientName));
        //waitElementToBeClickable(client);
        clientLink.click();
        return new ConfigappCoreSettingsPage(getDriver());
    }

}
