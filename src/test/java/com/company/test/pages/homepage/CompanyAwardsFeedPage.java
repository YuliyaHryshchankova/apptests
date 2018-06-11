package com.company.test.pages.homepage;

import com.company.test.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextBlock;

public class CompanyAwardsFeedPage extends BasePage {

    @Name("View All Awards")
    @FindBy(id = "viewAllNews")
    private Link viewAllLink;

    @Name("Award Title Value")
    @FindBy(xpath = "//*[@id='awardNewsFeedContainer']/div[2]//h3[@class='heading noMargin']")
    private TextBlock valueOfAwardTitleTextBlock;

    @Name("Award Message Value")
    @FindBy(id = "awardMessage_1")
    private TextBlock valueOfAwardMessageTextBlock;

    public CompanyAwardsFeedPage(WebDriver driver) {
        super(driver);
    }

    public void viewAllAwards() {
        viewAllLink.click();
        waitUntilVisible(valueOfAwardTitleTextBlock);
    }

    public String getVerifyAwardTitleValue() {
        return valueOfAwardTitleTextBlock.getText();
    }

    public String getVerifyAwardMessageValue() {
        return valueOfAwardMessageTextBlock.getText();
    }

}
