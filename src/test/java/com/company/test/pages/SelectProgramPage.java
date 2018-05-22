package com.company.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectProgramPage extends BasePage {

    @FindBy(xpath = "//div[@class='js-np-award-program-item np-award-program-default np-award-program relative']")
    private WebElement awardProgram;

    public SelectProgramPage(WebDriver driver) {

        super(driver);
    }

    public void selectAwardProgram() {
        waitElementToBeClickable(awardProgram);
        awardProgram.click();

    }


}
