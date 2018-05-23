package com.company.test.pages.homepage;

import com.company.test.pages.BasePage;
import com.company.test.pages.mydashboard.MyDashboardPage;
import org.openqa.selenium.By;
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

    private By nominateAnotherColleague = By.xpath("//*[@id='np_mainNotification']/div/div");
    //(id = "np_mainNotification")

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

    public MainMenuPage waitNominateAnotherColleaguePageClose() {
        if (isElementPresent(nominateAnotherColleague)) {
            waitElementInvisible(nominateAnotherColleague);
        }
        return this;
    }

    public MyDashboardPage goToMyDashboard() {
        myDashboard.click();
        return new MyDashboardPage(getDriver());

    }

    public void clickAcceptCookie() {
        if (isElementPresent(acceptCookieLink)) {
            acceptCookieLink.click();

        }
    }
}


