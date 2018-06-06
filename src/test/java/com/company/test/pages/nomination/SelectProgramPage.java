package com.company.test.pages.nomination;

import com.company.test.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class SelectProgramPage extends BasePage {

    @Name("Award Program")
    @FindBy(xpath = "//div[@class='js-np-award-program-item np-award-program-default np-award-program relative']")
    private HtmlElement awardProgramItem;

    public SelectProgramPage(WebDriver driver) {

        super(driver);
    }

    public SelectAwardReasonPage selectAwardProgram() {
        waitElementToBeClickable(awardProgramItem);
        awardProgramItem.click();
        return new SelectAwardReasonPage(getDriver());

    }


}
