package com.company.test.pages.mydashboard.mynominations;

import com.company.test.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyNominationsPage extends BasePage {

    @FindBy(xpath = "//*[@id='my_nomination']/table//tr[1]/td[1]")
    private WebElement dateInFirstRow;

    @FindBy(xpath = "//*[@id='my_nomination']/table//tr[1]/td[2]")
    private WebElement awardTypeInFirstRow;

    @FindBy(xpath = "//*[@id='my_nomination']/table//tr[1]/td[3]")
    private WebElement awardAmountInFirstRow;

    @FindBy(xpath = "//*[@class='detailsLink a-tooltip-target']")
    private WebElement nominationDetailsIcon;

    public MyNominationsPage(WebDriver driver) {

        super(driver);
    }

    public NominationDetailsPage openNominationDetails() {
        nominationDetailsIcon.click();
        waitElementToBeClickable(By.xpath("//a[@class='container-close']"));
        return new NominationDetailsPage(driver);
    }


}
