package com.company.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GDPRPage extends BasePage {

    @FindBy(xpath = "//button[@class='btn btn--primary']")
    private WebElement gdbr;

    public GDPRPage(WebDriver driver) {

        super(driver);
    }

    public void acceptGDPR() {
        if (isElementPresent(gdbr)) {
            gdbr.click();
        }

    }
}