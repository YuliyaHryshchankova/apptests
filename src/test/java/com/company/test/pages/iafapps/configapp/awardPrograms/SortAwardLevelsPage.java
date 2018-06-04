package com.company.test.pages.iafapps.configapp.awardPrograms;

import com.company.test.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SortAwardLevelsPage extends BasePage {

    @FindBy(xpath="//*[@id='dlg']/a")
    private WebElement closeIcon;

    public SortAwardLevelsPage(WebDriver driver) {
        super(driver);
    }

    public SortAwardLevelsPage moveAwardLevel() {
        List<WebElement> listOfAwards = driver.findElements(By.xpath("//*[@id='current_items']/li"));
              Actions actions = new Actions(driver);
        actions.dragAndDrop(listOfAwards.get(3), listOfAwards.get(1)).build().perform();
        return this;
    }

    public ManageAwardProgramsPage closeSortAwardLevelsPopup() {
        closeIcon.click();
        return new ManageAwardProgramsPage(getDriver());
    }


}
