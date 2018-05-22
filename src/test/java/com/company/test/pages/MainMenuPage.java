package com.company.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainMenuPage extends BasePage {

    @FindBy(xpath = "//a[@href='/microsites/t/home?client=testclientclone3' and @target='_self']")
    private WebElement homeTab;

    @FindBy(xpath = "//a[@id='np_start']")
    private WebElement recognize;

    @FindBy(xpath = "//span[2]/a[@href='/microsites/t/dashboard/MyActivity?client=testclientclone3']")
    private WebElement myDashboard;


    @FindBy(xpath = "//button[@class='cookie-accept-btn']")
    private WebElement acceptCookieLink;

    public MainMenuPage(WebDriver driver) {
        super(driver);
    }

    public boolean homeTabLocationDisplayed() {
        return isElementPresent(homeTab);
    }

    public MainMenuPage clickRecognize() {
        recognize.click();
        return this;
    }

    public void goToMyDashboard() {
        waitElementToBeClickable(myDashboard);
        myDashboard.click();

    }

    public void clickAcceptCookie() {
        if (isElementPresent(acceptCookieLink)) {
            acceptCookieLink.click();

        }
    }
}


