package com.company.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NominationDetailsPage extends BasePage{

    @FindBy(xpath="//a[@class='container-close']")
    private WebElement closeIcon;

    @FindBy(xpath="//tr[5]/td[1][@class='col5']")
    private WebElement awardTitleValue;

    @FindBy(xpath="//td[@class='grid_7 messageLtr']")
    private WebElement awardMessageValue;

    public NominationDetailsPage(WebDriver driver) {

        super(driver);
    }

    public String verifyAwardTitleValue() {
        return awardTitleValue.getText();
    }

    public String verifyAwardMessageValue() {
        return awardMessageValue.getText();
    }

    public void clickCloseIcon() {
        waitElementToBeClickable(closeIcon);
        closeIcon.click();
    }

}
