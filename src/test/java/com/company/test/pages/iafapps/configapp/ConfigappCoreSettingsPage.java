package com.company.test.pages.iafapps.configapp;

import com.company.test.pages.BasePage;
import com.company.test.pages.iafapps.configapp.awardPrograms.ManageAwardProgramsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfigappCoreSettingsPage extends BasePage {

    @FindBy(xpath = "//span[contains(@class, 'ygtvlabel') and text() = 'Awards']")
    //(xpath="//td[@id='ygtvlabelel38']")
    //(id="ygtvlabelel38")
    private WebElement awardsSection;

    @FindBy(xpath = "//a[contains(@class, 'ygtvlabel') and text() = 'Award Programs']")
    //(id="ygtvlabelel39")
    private WebElement awardProgramsSection;

    public ConfigappCoreSettingsPage(WebDriver driver) {
        super(driver);
    }

    public ManageAwardProgramsPage openAwardPrograms() {
        //waitElementToBeClickable(awardsSection);
        awardsSection.click();
        waitElementToBeClickable(awardProgramsSection);
        awardProgramsSection.click();
        return new ManageAwardProgramsPage(getDriver());
    }


}
