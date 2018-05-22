package com.company.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AwardAdvisorPage extends BasePage {

    @FindBy(xpath = "//a[@class='js-np-skip-advisor block np-advisor-skip-link award_reason_1_color']")
    private WebElement skipAwardAdvisorButton;

    public AwardAdvisorPage(WebDriver driver) {

        super(driver);
    }

    public void skipAwardAdvisor() {
        waitElementToBeClickable(skipAwardAdvisorButton);
        skipAwardAdvisorButton.click();

    }
}
