package com.company.test.pages.nomination;

import com.company.test.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;

public class ChoseNominatorPage extends BasePage {

    @Name("Nominate as Myself Button")
    @FindBy(xpath = "//button[@class='js-np-recipient-item gf-btn btn-primary btn-lg']")
    private Button nominateAsMyselfButton;

    public ChoseNominatorPage(WebDriver driver) {
        super(driver);
    }

    public SelectRecipientPage selectNominator() {
        waitElementToBeClickable(nominateAsMyselfButton);
        nominateAsMyselfButton.click();
        return new SelectRecipientPage(getDriver());
    }


}
