package com.company.test.scenarios.nomination;

import com.company.test.businessobjects.Nomination;
import com.company.test.pages.homepage.CompanyAwardsFeedPage;
import com.company.test.pages.homepage.MainMenuPage;
import com.company.test.pages.mydashboard.mynominations.NominationDetailsPage;
import com.company.test.scenarios.BaseTest;
import com.company.test.services.nomination.NominationService;
import com.company.test.staticfactory.NominationStaticFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AwardCreateTest extends BaseTest {

    NominationService nominationService;
    Nomination nomination;

    @Test(description = "Verify Award Creation", priority = 2)
    public void verifyAwardCreate() {
        nomination = NominationStaticFactory.createDefaultNomination();
        nominationService = new NominationService(driver);
        nominationService.createAward(nomination);

        Assert.assertTrue(nominationService.homeTabLocationDisplayed(), "Login Failed");
    }

    @Test(description = "Verify created award is present on My Nominations", priority = 3, dependsOnMethods = "verifyAwardCreate")
    public void verifyAwardPresentOnMyNominations() {
        nominationService = new NominationService(driver);
        nominationService.openNominationDetails();

        Assert.assertEquals(nominationService.getVerifyAwardTitleValue(), nomination.getAwardTitle(), "Award title failed validation");
        Assert.assertEquals(nominationService.getVerifyAwardMessageValue(), nomination.getAwardMessage(), "Award message failed validation");

        new NominationDetailsPage(driver)
                .clickCloseIcon();
    }

    @Test(description = "Verify created award is present on News Feed", priority = 4, dependsOnMethods = "verifyAwardCreate")
    public void verifyAwardPresentOnNewFeed() {
        long timeOut = 180000;
        long start = System.currentTimeMillis();
        CompanyAwardsFeedPage companyAwardsFeedPage = new CompanyAwardsFeedPage(driver);

            new MainMenuPage(driver)
                    .clickHomeTab();

            while (System.currentTimeMillis() - start < timeOut) {
                new CompanyAwardsFeedPage(driver)
                        .viewAllAwards();
            if (companyAwardsFeedPage.getVerifyAwardTitleValue().equals(nomination.getAwardTitle())) {
                break;
            }
        }

        Assert.assertEquals(companyAwardsFeedPage.getVerifyAwardTitleValue(), nomination.getAwardTitle(), "Award title failed validation");
        Assert.assertEquals(companyAwardsFeedPage.getVerifyAwardMessageValue(), nomination.getAwardMessage(), "Award message failed validation");
    }

}
