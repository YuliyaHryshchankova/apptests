package com.company.test.pages.iafapps.configapp.awardprograms;

import com.company.test.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;

import java.util.List;

public class SortAwardLevelsPage extends BasePage {

    @Name("Close Button")
    @FindBy(xpath = "//*[@id='dlg']/a")
    private Button closeIconButton;

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
        closeIconButton.click();
        return new ManageAwardProgramsPage(getDriver());
    }


}
