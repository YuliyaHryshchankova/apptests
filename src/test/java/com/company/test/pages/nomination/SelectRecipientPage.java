package com.company.test.pages.nomination;

import com.company.test.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectRecipientPage extends BasePage {

    @FindBy(xpath = "//ul[@class='np-recipient-list list-unstyled clearfix']//h4[@data-title='Tony Kozlowsky']")
    private WebElement nominee;

    @FindBy(xpath = "//button[@class='js-np-next gf-btn btn-primary btn-block btn-lg inline-block']")
    private WebElement nextButon;

    public SelectRecipientPage(WebDriver driver) {

        super(driver);
    }

    public void selectNominee() {
        waitElementToBeClickable(nominee);
        nominee.click();
        nextButon.click();

    }

}
