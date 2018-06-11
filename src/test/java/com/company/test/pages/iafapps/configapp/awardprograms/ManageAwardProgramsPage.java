package com.company.test.pages.iafapps.configapp.awardprograms;

import com.company.test.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Link;

public class ManageAwardProgramsPage extends BasePage {

    @Name("Sort Award Levels for first program in the list")
    @FindBy(xpath = "//*[@id='yui-rec0']/td[2]")
    private Link sortAwardLevelsLink;

    public ManageAwardProgramsPage(WebDriver driver) {
        super(driver);
    }

    public SortAwardLevelsPage openSortAwardLevelsPopup() {
        waitElementToBeClickable(sortAwardLevelsLink);
        sortAwardLevelsLink.click();
        return new SortAwardLevelsPage(getDriver());
    }


}
