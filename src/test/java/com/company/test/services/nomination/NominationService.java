package com.company.test.services.nomination;

import com.company.test.businessobjects.Nomination;
import com.company.test.pages.homepage.MainMenuPage;
import com.company.test.pages.mydashboard.MyDashboardPage;
import com.company.test.pages.mydashboard.mynominations.NominationDetailsPage;
import org.openqa.selenium.WebDriver;

public class NominationService {

    private WebDriver driver;

    public NominationService(WebDriver driver) {
        this.driver = driver;
    }

    public void createAward(String awardTitle, String awardMessage) {

        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        mainMenuPage
                .clickRecognize()
                .selectNominator()
                .selectNominee()
                .selectAwardProgram()
                .selectAwardReason()
                .skipAwardAdvisor()
                .selectAwardType()
                .sendAward(awardTitle, awardMessage)
                .completeRecognition();
    }

    public void createAward(Nomination nomination) {
        createAward(nomination.getAwardTitle(), nomination.getAwardMessage());
    }

    public void openNominationDetails() {
        MyDashboardPage myDashboardPage = new MainMenuPage(driver)
                .waitNominateAnotherColleaguePageClose()
                .goToMyDashboard();

        myDashboardPage
                .clickMyNominations()
                .openNominationDetails();
    }

    public boolean homeTabLocationDisplayed() {
        return new MainMenuPage(this.driver).homeTabLocationDisplayed();
    }

    public String getVerifyAwardTitleValue() {
        return new NominationDetailsPage(this.driver).getVerifyAwardTitleValue();
    }

    public String getVerifyAwardMessageValue() {
        return new NominationDetailsPage(this.driver).getVerifyAwardMessageValue();
    }

}
