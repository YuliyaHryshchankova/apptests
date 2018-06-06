package com.company.test.pages.nomination;

import com.company.test.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class AwardMessagePage extends BasePage {

    @Name("Award Title Input field")
    @FindBy(xpath = "//textarea[@id='np_awardTitle']")
    private TextInput awardTitle;

    @Name("Award Message Input field")
    @FindBy(xpath = "//textarea[@id='np_awardMessage']")
    private TextInput awardMessage;

    @Name("Send Award Button")
    @FindBy(xpath = "//button[@class='js-np-send-award gf-btn btn-primary btn-lg btn-block inline-block']")
    private Button sendAwardButton;


    public AwardMessagePage(WebDriver driver) {

        super(driver);
    }

    public NominateAnotherColleaguePage sendAward(String titleOfAward, String message) {
        waitElementToBeClickable(awardTitle);
        awardTitle.sendKeys(titleOfAward);
        waitElementToBeClickable(awardMessage);
        awardMessage.sendKeys(message);
        waitElementToBeClickable(sendAwardButton);
        sendAwardButton.click();
        return new NominateAnotherColleaguePage(driver);

    }


}
