package com.company.test.pages.homepage;

import com.company.test.pages.BasePage;
import com.company.test.pages.LogInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RightTopMenuPage extends BasePage {

    @FindBy(xpath = "//a[@href='/microsites/t/home?logout&client=testclientclone3']")
    private WebElement logOutLink;

    public RightTopMenuPage(WebDriver driver) {

        super(driver);
    }

    public LogInPage clickLogOutLink() {

        logOutLink.click();
        return new LogInPage(driver);
    }


}
