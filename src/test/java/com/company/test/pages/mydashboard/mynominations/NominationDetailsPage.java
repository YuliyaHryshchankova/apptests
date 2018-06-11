package com.company.test.pages.mydashboard.mynominations;

import com.company.test.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextBlock;

public class NominationDetailsPage extends BasePage {

    @Name("Close Nomination Details")
    @FindBy(xpath = "//a[@class='container-close']")
    private Button closeButton;

    @Name("Value of award Title")
    @FindBy(xpath = "//tr[5]/td[1][@class='col5']")
    private TextBlock awardTitleValue;

    @Name("Value of Award Message")
    @FindBy(xpath = "//td[@class='grid_7 messageLtr']")
    private TextBlock awardMessageValue;

    public NominationDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getVerifyAwardTitleValue() {
        return awardTitleValue.getText();
    }

    public String getVerifyAwardMessageValue() {
        return awardMessageValue.getText();
    }

    public void clickCloseIcon() {
        waitElementToBeClickable(closeButton);
        closeButton.click();
    }

}
