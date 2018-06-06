package com.company.test.pages.mydashboard;

import com.company.test.pages.BasePage;
import com.company.test.pages.mydashboard.mynominations.MyNominationsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Link;

public class MyDashboardPage extends BasePage {

 /*   @Name("Search form")
    @Block(@FindBy(id="subNavBarContainer"))
*/
    @Name("My Nominations")
    @FindBy(xpath = "//a[@href='/microsites/t/dashboard/MyNominations?client=testclientclone3']")
    private Link myNominationsLink;

    public MyDashboardPage(WebDriver driver) {

        super(driver);
    }

    public MyNominationsPage clickMyNominations() {

        myNominationsLink.click();
        return new MyNominationsPage(getDriver());


    }
}
