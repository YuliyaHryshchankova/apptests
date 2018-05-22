package com.company.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AwardMessagePage extends BasePage {

    @FindBy(xpath = "//textarea[@id='np_awardTitle']")
    private WebElement awardTitle;

    @FindBy(xpath = "//textarea[@id='np_awardMessage']")
    private WebElement awardMessage;

    @FindBy(xpath = "//button[@class='js-np-send-award gf-btn btn-primary btn-lg btn-block inline-block']")
    private WebElement sendAwardButton;


    public AwardMessagePage(WebDriver driver) {

        super(driver);
    }

    public AwardMessagePage sendAward(String titleOfAward, String message) {
        waitElementToBeClickable(awardTitle);
        awardTitle.sendKeys(titleOfAward);
        waitElementToBeClickable(awardMessage);
        awardMessage.sendKeys(message);
        waitElementToBeClickable(sendAwardButton);
        sendAwardButton.click();
        return new AwardMessagePage(driver);

    }


}
