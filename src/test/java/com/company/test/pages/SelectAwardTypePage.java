package com.company.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectAwardTypePage extends BasePage {

    @FindBy(xpath = "//div[3]/bdi")
    private WebElement awardType;

    public SelectAwardTypePage(WebDriver driver) {

        super(driver);
    }

    public void selectAwardType() {
        waitElementToBeClickable(awardType);
        awardType.click();

    }

}
