package com.company.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyDashboardPage extends BasePage {

    @FindBy(xpath = "//a[@href='/microsites/t/dashboard/MyNominations?client=testclientclone3']")
    private WebElement myNominations;

    public MyDashboardPage(WebDriver driver) {

        super(driver);
    }

    public void clickMyNominations() {
        myNominations.click();

    }
}
