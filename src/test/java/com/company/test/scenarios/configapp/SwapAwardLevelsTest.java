package com.company.test.scenarios.configapp;

import com.company.test.businessobjects.IafUser;
import com.company.test.pages.iafapps.IafHomePage;
import com.company.test.scenarios.BaseTest;
import com.company.test.services.login.LogInToIafAppService;
import com.company.test.staticfactory.UsersStaticFactory;
import org.testng.annotations.Test;

public class SwapAwardLevelsTest extends BaseTest {

    LogInToIafAppService logInToIafAppService;

    private String clientName = "Test Client AT Nominator";

    @Test(description = "Successful swapping of award programs for 5021 client", priority = 0)
    public void swapAwardLevelTest() {
        logger.info("Checking swapping of award programs");

        IafUser iafUser = UsersStaticFactory.createDefaultIafUser();

        logInToIafAppService = new LogInToIafAppService(driver);

        logInToIafAppService.logInToIafApp(iafUser);

        new IafHomePage(driver)

                .openConfigApp()
                .clickClientLink(clientName)
                .openAwardPrograms()
                .openSortAwardLevelsPopup()
                .moveAwardLevel();
        //.closeSortAwardLevelsPopup();

    }


}
