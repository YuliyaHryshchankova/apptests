package com.company.test.pages.nomination;

import com.company.test.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;

public class AwardAdvisorPage extends BasePage {

    @Name("Skip Award Advisor")
    @FindBy(xpath = "//a[@class='js-np-skip-advisor block np-advisor-skip-link award_reason_1_color']")
    private Button skipAwardAdvisorButton;

    public AwardAdvisorPage(WebDriver driver) {

        super(driver);
    }

    public SelectAwardTypePage skipAwardAdvisor() {
        waitElementToBeClickable(skipAwardAdvisorButton);
        skipAwardAdvisorButton.click();
        return new SelectAwardTypePage(getDriver());

    }
}
