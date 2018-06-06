package com.company.test.pages.homepage;

import com.company.test.pages.BasePage;
import com.company.test.services.logInServices.LogInToClientSite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Link;

public class RightTopMenuPage extends BasePage {

    @Name("Log out link")
    @FindBy(xpath = "//a[@href='/microsites/t/home?logout&client=testclientclone3']")
    private Link logOutLink;

    public RightTopMenuPage(WebDriver driver) {

        super(driver);
    }

    public LogInToClientSite clickLogOutLink() {

        logOutLink.click();
        return new LogInToClientSite(driver);
    }


}
