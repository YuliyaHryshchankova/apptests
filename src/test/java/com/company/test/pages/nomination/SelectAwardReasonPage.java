package com.company.test.pages.nomination;

import com.company.test.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Image;

public class SelectAwardReasonPage extends BasePage {

    @Name("Award Reason")
    @FindBy(xpath = "//div[contains(@class, '1_bg_color')]")
    private HtmlElement awardReasonItem;

    public SelectAwardReasonPage(WebDriver driver) {

        super(driver);
    }

    public AwardAdvisorPage selectAwardReason() {
        waitElementToBeClickable(awardReasonItem);
        awardReasonItem.click();
        return new AwardAdvisorPage(getDriver());

    }

}
