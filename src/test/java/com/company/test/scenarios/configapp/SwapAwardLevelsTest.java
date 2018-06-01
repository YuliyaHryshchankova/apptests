package com.company.test.scenarios.configapp;

import com.company.test.pages.iafapps.IafLoginPage;
import com.company.test.scenarios.BaseTest;
import org.testng.annotations.Test;

public class SwapAwardLevelsTest extends BaseTest {

    private String username = "bhkb.jshcw@gqfozpkzgb.kbk";
    private String password = "password1";

    @Test(description = "Successful swapping of award programs for 5021 client", priority = 0)
    public void swapAwardProgramsTest() {

        new IafLoginPage(driver)
                .openURL()
                .loginToIaf(username, password)
                .openConfigApp()
                .clickClientLink()
                .openAwardPrograms()
                .openSortAwardLevelsPopup()
                .moveAwardLevel();
        //.closeSortAwardLevelsPopup();

    }

}
