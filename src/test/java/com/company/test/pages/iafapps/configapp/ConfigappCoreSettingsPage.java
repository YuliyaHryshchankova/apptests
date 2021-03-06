package com.company.test.pages.iafapps.configapp;

import com.company.test.pages.BasePage;
import com.company.test.pages.iafapps.configapp.awardprograms.ManageAwardProgramsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.TextBlock;

public class ConfigappCoreSettingsPage extends BasePage {

    @Name("Award Section")
    @FindBy(xpath = "//span[contains(@class, 'ygtvlabel') and text() = 'Awards']")
    private TextBlock awardsSectionTextBlock;

    @Name("Award Program Sub-Section")
    @FindBy(xpath = "//a[contains(@class, 'ygtvlabel') and text() = 'Award Programs']")
    private TextBlock awardProgramsSectionTextBlock;

    public ConfigappCoreSettingsPage(WebDriver driver) {
        super(driver);
    }

    public ManageAwardProgramsPage openAwardPrograms() {
        //waitElementToBeClickable(awardsSection);
        awardsSectionTextBlock.click();
        waitElementToBeClickable(awardProgramsSectionTextBlock);
        awardProgramsSectionTextBlock.click();
        return new ManageAwardProgramsPage(getDriver());
    }


}
