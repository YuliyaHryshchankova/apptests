package com.company.test.pages.nomination;

import com.company.test.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class SelectRecipientPage extends BasePage {

    @Name("Recipient of the award")
    @FindBy(xpath = "//ul[@class='np-recipient-list list-unstyled clearfix']//h4[@data-title='Tony Kozlowsky']")
    private HtmlElement nominee;

    @Name("Next button")
    @FindBy(xpath = "//button[@class='js-np-next gf-btn btn-primary btn-block btn-lg inline-block']")
    private Button nextButon;

    public SelectRecipientPage(WebDriver driver) {

        super(driver);
    }

    public SelectProgramPage selectNominee() {
        waitElementToBeClickable(nominee);
        nominee.click();
        nextButon.click();
        return new SelectProgramPage(getDriver());

    }

}
