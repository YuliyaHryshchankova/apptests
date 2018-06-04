package com.company.test.pages.iafapps.configapp.awardPrograms;

import com.company.test.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageAwardProgramsPage extends BasePage {

    @FindBy(xpath = "//*[@id='yui-rec0']/td[2]")
    private WebElement sortAwardLevels;

    public ManageAwardProgramsPage(WebDriver driver) {
        super(driver);
    }

    public SortAwardLevelsPage openSortAwardLevelsPopup() {
        waitElementToBeClickable(sortAwardLevels);
        sortAwardLevels.click();
        return new SortAwardLevelsPage(getDriver());
    }


}
