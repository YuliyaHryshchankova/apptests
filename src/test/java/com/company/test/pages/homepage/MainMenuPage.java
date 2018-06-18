package com.company.test.pages.homepage;

import com.company.test.pages.BasePage;
import com.company.test.pages.mydashboard.MyDashboardPage;
import com.company.test.pages.nomination.ChoseNominatorPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Link;

public class MainMenuPage extends BasePage {

    @Name("Home Tab")
    @FindBy(xpath = "//a[@href='/microsites/t/home?client=testclientclone3' and @target='_self']")
    private Link homeLink;

    @Name("Recognize Tab")
    @FindBy(xpath = "//a[@id='np_start']")
    private Link recognizeLink;

    @Name("My Dashboard Tab")
    @FindBy(xpath = "//span[2]/a[@href='/microsites/t/dashboard/MyActivity?client=testclientclone3']")
    private Link myDashboardLink;

    @Name("'I accept' button")
    @FindBy(xpath = "//button[@class='cookie-accept-btn']")
    private Button acceptCookieButton;

    private By nominateAnotherColleague = By.xpath("//*[@id='np_mainNotification']/div/div");
    //(id = "np_mainNotification")

    public MainMenuPage(WebDriver driver) {
        super(driver);
    }

    public boolean homeTabLocationDisplayed() {
        return isElementPresent(homeLink);
    }

    public ChoseNominatorPage clickRecognize() {
        recognizeLink.click();
        return new ChoseNominatorPage(getDriver());
    }

    public CompanyAwardsFeedPage clickHomeTab() {
        homeLink.click();
        return new CompanyAwardsFeedPage(getDriver());
    }

    public MainMenuPage waitNominateAnotherColleaguePageClose() {
        if (isElementPresent(nominateAnotherColleague)) {
            waitElementInvisible(nominateAnotherColleague);
        }
        return this;
    }

    public MyDashboardPage goToMyDashboard() {
        myDashboardLink.click();
        return new MyDashboardPage(getDriver());
    }

    public void clickAcceptCookie() {
        if (isElementPresent(acceptCookieButton)) {
            acceptCookieButton.click();
        }
    }


}


