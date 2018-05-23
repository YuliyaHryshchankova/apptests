package com.company.test.pages.nomination;

import com.company.test.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectAwardReasonPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, '1_bg_color')]")
    private WebElement awardReason;

    public SelectAwardReasonPage(WebDriver driver) {

        super(driver);
    }

    public void selectAwardReason() {
        waitElementToBeClickable(awardReason);
        awardReason.click();

    }

}
