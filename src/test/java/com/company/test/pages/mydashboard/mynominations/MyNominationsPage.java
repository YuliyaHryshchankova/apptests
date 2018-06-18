package com.company.test.pages.mydashboard.mynominations;

import com.company.test.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Link;

public class MyNominationsPage extends BasePage {

/*    @FindBy(xpath = "//*[@id='my_nomination']/table//tr[1]/td[1]")
    private WebElement dateInFirstRow;

    @FindBy(xpath = "//*[@id='my_nomination']/table//tr[1]/td[2]")
    private WebElement awardTypeInFirstRow;

    @FindBy(xpath = "//*[@id='my_nomination']/table//tr[1]/td[3]")
    private WebElement awardAmountInFirstRow;*/

    @Name("Nomination Details")
    @FindBy(xpath = "//*[@class='detailsLink a-tooltip-target']")
    private Link nominationDetailsIconLink;

    public MyNominationsPage(WebDriver driver) {
        super(driver);
    }

    public NominationDetailsPage openNominationDetails() {
        nominationDetailsIconLink.click();
        waitElementToBeClickable(By.xpath("//a[@class='container-close']"));
        return new NominationDetailsPage(driver);
    }


}
