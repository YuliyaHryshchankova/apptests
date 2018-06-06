package com.company.test.pages.nomination;

import com.company.test.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;

public class NominateAnotherColleaguePage extends BasePage {

    @Name("Close button")
    @FindBy(xpath = "//button[@class='js-np-close gf-btn btn-primary btn-block btn-lg inline-block']")
    private Button closeButton;

    public NominateAnotherColleaguePage(WebDriver driver) {

        super(driver);
    }


    public NominateAnotherColleaguePage completeRecognition() {
        waitElementToBeClickable(closeButton);
        closeButton.click();
        return this;
    }


}
