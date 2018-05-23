package com.company.test.scenarios;

import com.company.test.pages.homepage.MainMenuPage;
import com.company.test.pages.mydashboard.MyDashboardPage;
import com.company.test.pages.mydashboard.mynominations.MyNominationsPage;
import com.company.test.pages.mydashboard.mynominations.NominationDetailsPage;
import com.company.test.pages.nomination.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class AwardCreateTest extends BaseTest {


    private String titleOfAward = "test title";
    private String message = "test message";
    private Random rand = new Random();


    @Test(description = "Verify Award Creation", priority = 2)
    public void verifyAwardCreate() {

        titleOfAward = titleOfAward + String.valueOf(rand.nextInt(999));
        message = message + String.valueOf(rand.nextInt(999));

        MainMenuPage mainMenuPage = new MainMenuPage(driver)
                .clickRecognize();

        new ChoseNominatorPage(driver)
                .selectNominator();

        new SelectRecipientPage(driver)
                .selectNominee();

        new SelectProgramPage(driver)
                .selectAwardProgram();

        new SelectAwardReasonPage(driver)
                .selectAwardReason();

        new AwardAdvisorPage(driver)
                .skipAwardAdvisor();

        new SelectAwardTypePage(driver)
                .selectAwardType();

        new AwardMessagePage(driver)
                .sendAward(titleOfAward, message);

        new NominateAnotherColleaguePage(driver)
                .completeRecognition();

        Assert.assertTrue(mainMenuPage.homeTabLocationDisplayed(), "Login Failed");

    }


    @Test(description = "Verify created award is present on My Nominations", priority = 3, dependsOnMethods = "verifyAwardCreate")

    public void verifyAwardPresentOnMyNominations() {


        MyDashboardPage myDashboardPage = new MainMenuPage(driver)
                .waitNominateAnotherColleaguePageClose()
                .goToMyDashboard();

        myDashboardPage
                .clickMyNominations();

        new MyNominationsPage(driver)
                .openNominationDetails();

        NominationDetailsPage nominationDetailsPage = new NominationDetailsPage(driver);
        Assert.assertEquals(nominationDetailsPage.getVerifyAwardTitleValue(), titleOfAward, "Award title failed validation");
        Assert.assertEquals(nominationDetailsPage.getVerifyAwardMessageValue(), message, "Award message failed validation");

        new NominationDetailsPage(driver)
                .clickCloseIcon();


    }


}
