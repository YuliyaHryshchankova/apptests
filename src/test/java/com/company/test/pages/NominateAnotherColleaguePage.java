package com.company.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NominateAnotherColleaguePage extends BasePage {
    @FindBy(xpath="//*[@id='np_mainNotification']/div/div")
            //(id = "np_mainNotification")
    private WebElement nominateAnotherColleague;

    @FindBy(xpath = "//button[@class='js-np-close gf-btn btn-primary btn-block btn-lg inline-block']")
    private WebElement closeButton;

    public NominateAnotherColleaguePage(WebDriver driver) {

        super(driver);
    }


    public NominateAnotherColleaguePage completeRecognition() {
        waitElementToBeClickable(closeButton);
        closeButton.click();
        if (isElementPresent(nominateAnotherColleague)) {
            waitElementInvisible(nominateAnotherColleague);
        }
        return this;
    }


}
