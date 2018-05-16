package com.company.test;

import com.company.test.utils.Constants;
import com.company.test.utils.PreConfig;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AwardCreateTest extends PreConfig {

    private static final String URL = "https://staging-web1.corp.globoforce.com/microsites/t/home?client=testclientclone3&setCAG=true";
    private String username = "E2029318";
    private String password = "password1";
    private String titleOfAward = "test title";
    private String message = "test message";

    @Test(description = "Successful login", priority = 1)
    public void successLogin() {
        driver.navigate().to(URL);
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.id("signIn-button")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //check whether Welcome page with Privacy Policy and Terms of Use is opened. If YES, click 'Okay - Let's go' button.
        if (!driver.findElements(By.xpath("//button[@class='btn btn--primary']")).isEmpty()) {
            driver.findElement(By.xpath("//button[@class='btn btn--primary']")).click();
        }
        //check whether 'cookie policy' popup is present. If YES, click 'I accept' button.
        if (!driver.findElements(By.xpath("//button[@class='cookie-accept-btn']")).isEmpty()) {
            driver.findElement(By.xpath("//button[@class='cookie-accept-btn']")).click();
        }
        driver.manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);

        Assert.assertTrue(driver.findElement(By.xpath("//a[@href='/microsites/t/home?client=testclientclone3' and @target='_self']")).isDisplayed(), "Login Failed");
    }


    @Test(description = "Verify Award Creation", priority = 2, dependsOnMethods = "successLogin")
    public void verifyAwardCreate() {

        driver.findElement(By.xpath("//a[@id='np_start']")).click();
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
        Assert.assertTrue(driver.findElement(By.xpath("//a[@href='/microsites/t/home?client=testclientclone3' and @target='_self']")).isDisplayed(), "Award Creation Failed");
        waitElementInvisible(By.id("np_mainNotification"));

    }

    @Test(description = "Successful  logout", priority = 3, dependsOnMethods = "verifyAwardCreate")
    public void successLogOut() {
        driver.findElement(By.xpath("//a[@href='/microsites/t/home?logout&client=testclientclone3']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='signIn-button']")).isDisplayed(), "Logout Failed");
    }


}
