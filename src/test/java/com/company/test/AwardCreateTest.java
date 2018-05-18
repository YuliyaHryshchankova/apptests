package com.company.test;

import com.company.test.utils.Constants;
import com.company.test.utils.PreConfig;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AwardCreateTest extends PreConfig {

    private String titleOfAward = "test title";
    private String message = "test message";

    @Test(description = "Successful login", priority = 1)
    public void successLogin() {
        driver.navigate().to(Constants.URL);
        driver.findElement(Constants.USERNAME_FIELD).sendKeys(Constants.USERNAME);
        driver.findElement(Constants.PASSWORD_FIELD).sendKeys(Constants.PASSWORD);
        driver.findElement(Constants.SIGN_IN_BUTTON).click();
        //driver.findElement(By.id("signIn-button")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //check whether Welcome page with Privacy Policy and Terms of Use is opened. If YES, click 'Okay - Let's go' button.
        if (!driver.findElements(Constants.GDPR).isEmpty()) {
            driver.findElement(Constants.GDPR).click();
        }
        //check whether 'cookie policy' popup is present. If YES, click 'I accept' button.
        if (!driver.findElements(Constants.COOKIE_ACCEPT).isEmpty()) {
            driver.findElement(Constants.COOKIE_ACCEPT).click();
        }
        driver.manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);

        Assert.assertTrue(driver.findElement(Constants.HOME_TAB).isDisplayed(), "Login Failed");
    }


    @Test(description = "Verify Award Creation", priority = 2, dependsOnMethods = "successLogin")
    public void verifyAwardCreate() {

        driver.findElement(Constants.RECOGNIZE).click();
        waitElementToBeClickable(Constants.NOMINATE_AS_MYSELF_BUTTON).click();
        waitElementToBeClickable(Constants.NOMINEE).click();
        waitElementToBeClickable(Constants.NEXT_BUTTON).click();
        waitElementToBeClickable(Constants.AWARD_PROGRAM).click();
        waitElementToBeClickable(Constants.AWARD_REASON).click();
        waitElementToBeClickable(Constants.SKIP_AWARD_ADVISOR).click();
        waitElementToBeClickable(Constants.AWARD_TYPE).click();
        waitElementToBeClickable(Constants.AWARD_TITLE).sendKeys(titleOfAward);
        waitElementToBeClickable(Constants.AWARD_MESSAGE).sendKeys(message);
        waitElementToBeClickable(Constants.SEND_AWARD_BUTTON).click();
        waitElementToBeClickable(Constants.CLOSE_BUTTON).click();
        Assert.assertTrue(driver.findElement(Constants.HOME_TAB).isDisplayed(), "Award Creation Failed");
        waitElementInvisible(By.id("np_mainNotification"));

    }

    @Test(description = "Successful logout", priority = 3, dependsOnMethods = "verifyAwardCreate")
    public void successLogOut() {
        driver.findElement(Constants.LOG_OUT).click();

        Assert.assertTrue(driver.findElement(Constants.SIGN_IN_BUTTON).isDisplayed(), "Logout Failed");
    }


}
