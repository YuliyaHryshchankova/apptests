package com.company.test.scenarios;

import com.company.test.pages.*;
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

        new MainMenuPage(driver)
                .goToMyDashboard();

        new MyDashboardPage(driver)
                .clickMyNominations();

        new MyNominationsPage(driver)
                .openNominationDetails();

        NominationDetailsPage nominationDetailsPage = new NominationDetailsPage(driver);
        Assert.assertEquals(nominationDetailsPage.verifyAwardTitleValue(), "Test award title");
        Assert.assertEquals(nominationDetailsPage.verifyAwardMessageValue(), "Test award title");

        new NominationDetailsPage(driver)
                .clickCloseIcon();


    }


}
