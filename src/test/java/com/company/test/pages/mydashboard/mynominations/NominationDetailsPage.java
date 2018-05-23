package com.company.test.pages.mydashboard.mynominations;

import com.company.test.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NominationDetailsPage extends BasePage {

    @FindBy(xpath = "//a[@class='container-close']")
    private WebElement closeIcon;

    @FindBy(xpath = "//tr[5]/td[1][@class='col5']")
    private WebElement awardTitleValue;

    @FindBy(xpath = "//td[@class='grid_7 messageLtr']")
    private WebElement awardMessageValue;

    public NominationDetailsPage(WebDriver driver) {

        super(driver);
    }

    public String getVerifyAwardTitleValue() {
        return awardTitleValue.getText();
    }

    public String getVerifyAwardMessageValue() {
        return awardMessageValue.getText();
    }

    public void clickCloseIcon() {
        waitElementToBeClickable(closeIcon);
        closeIcon.click();
    }

}
