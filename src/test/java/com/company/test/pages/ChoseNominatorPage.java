package com.company.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChoseNominatorPage extends BasePage {

    @FindBy(xpath = "//button[@class='js-np-recipient-item gf-btn btn-primary btn-lg']")
    private WebElement nominateAsMyself;

    public ChoseNominatorPage(WebDriver driver) {
        super(driver);
    }

    public void selectNominator() {
        waitElementToBeClickable(nominateAsMyself);
        nominateAsMyself.click();
    }


}
