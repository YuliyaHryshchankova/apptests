package com.company.test;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.ErrorCodes.TIMEOUT;

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
        if (!driver.findElements( By.xpath("//button[@class='btn btn--primary']") ).isEmpty()){
            driver.findElement(By.xpath("//button[@class='btn btn--primary']")).click();
         }
        //check whether 'cookie policy' popup is present. If YES, click 'I accept' button.
        if (!driver.findElements( By.xpath("//button[@class='cookie-accept-btn']") ).isEmpty()){
            driver.findElement(By.xpath("//button[@class='cookie-accept-btn']")).click();
        }
       driver.manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);

        Assert.assertTrue(driver.findElement(By.xpath("//a[@href='/microsites/t/home?client=testclientclone3' and @target='_self']")).isDisplayed(), "Login Failed");
    }


    @Test(description = "Verify Award Creation", priority = 2, dependsOnMethods = "successLogin")
    public void verifyAwardCreate() {

        driver.findElement(By.xpath("//a[@id='np_start']")).click();
        WebElement nominateAsMyself = waitElementToBeClickable(By.xpath("//button[@class='js-np-recipient-item gf-btn btn-primary btn-lg']"));
        nominateAsMyself.click();

        WebElement nominee = waitElementToBeClickable(By.xpath("//ul[@class='np-recipient-list list-unstyled clearfix']/li/div/h4[@data-title='Tony Kozlowsky']"));
        nominee.click();

        WebElement nextButton = waitElementToBeClickable(By.xpath("//button[@class='js-np-next gf-btn btn-primary btn-block btn-lg inline-block']"));
        nextButton.click();

        WebElement awardProgram = waitElementToBeClickable(By.xpath("//div[@class='js-np-award-program-item np-award-program-default np-award-program relative']"));
        awardProgram.click();

        WebElement awardReason = waitElementToBeClickable(By.xpath("//*[@id='np_awardReasons']/div/div/div[1]/div/div[1]/div/div[2]"));
        awardReason.click();

        WebElement skipAwardAdvisor = waitElementToBeClickable(By.xpath("//a[@class='js-np-skip-advisor block np-advisor-skip-link award_reason_1_color']"));
        skipAwardAdvisor.click();

        WebElement awardType = waitElementToBeClickable(By.xpath("//div[3]/bdi"));
        awardType.click();

        WebElement awardTitle = waitElementToBeClickable(By.xpath("//textarea[@id='np_awardTitle']"));
        awardTitle.sendKeys(titleOfAward);

        WebElement awardMessage = waitElementToBeClickable(By.xpath("//textarea[@id='np_awardMessage']"));
        awardMessage.sendKeys(message);

        WebElement sendAward = waitElementToBeClickable(By.xpath("//button[@class='js-np-send-award gf-btn btn-primary btn-lg btn-block inline-block']"));
        sendAward.click();

        WebElement closeButton = waitElementToBeClickable(By.xpath("//button[@class='js-np-close gf-btn btn-primary btn-block btn-lg inline-block']"));
        Assert.assertTrue(driver.findElement(By.xpath("//button[@class='js-np-close gf-btn btn-primary btn-block btn-lg inline-block']")).isDisplayed(), "Award Creation Failed");
        closeButton.click();

        waitElementInvisible(By.id("np_mainNotification"));

    }


    @Test(description = "Successful logout", priority = 3, dependsOnMethods = "verifyAwardCreate")
    public void successLogOut() {
        WebElement logOut = waitElementToBeClickable(By.xpath("//a[@href='/microsites/t/home?logout&client=testclientclone3']"));
        logOut.click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='signIn-button']")).isDisplayed(), "Logout Failed");
    }


}
