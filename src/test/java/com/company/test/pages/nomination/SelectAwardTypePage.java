package com.company.test.pages.nomination;

import com.company.test.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class SelectAwardTypePage extends BasePage {

    @Name("Award Type")
    @FindBy(xpath = "//div[3]/bdi")
    private HtmlElement awardTypeItem;

    public SelectAwardTypePage(WebDriver driver) {
        super(driver);
    }

    public AwardMessagePage selectAwardType() {
        waitElementToBeClickable(awardTypeItem);
        awardTypeItem.click();
        return new AwardMessagePage(getDriver());
    }

}
