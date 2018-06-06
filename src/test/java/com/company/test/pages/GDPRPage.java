package com.company.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;

public class GDPRPage extends BasePage {

    @Name("'OKay - let's go!' button")
    @FindBy(xpath = "//button[@class='btn btn--primary']")
    private Button gdprButton;

    public GDPRPage(WebDriver driver) {

        super(driver);
    }

    public void acceptGDPR() {
        if (isElementPresent(gdprButton)) {
            gdprButton.click();
        }

    }
}