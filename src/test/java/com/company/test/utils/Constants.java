package com.company.test.utils;

import org.openqa.selenium.By;

public interface Constants {

    String URL = "https://staging-web1.corp.globoforce.com/microsites/t/home?client=testclientclone3&setCAG=true";
    String USERNAME = "E2029318";
    String PASSWORD = "password1";

    By USERNAME_FIELD = By.name("username");
    By PASSWORD_FIELD = By.name("password");
    By RECOGNIZE = By.xpath("//a[@id='np_start']");
    By NOMINATE_AS_MYSELF_BUTTON = By.xpath("//button[@class='js-np-recipient-item gf-btn btn-primary btn-lg']");
    By NOMINEE = By.xpath("//ul[@class='np-recipient-list list-unstyled clearfix']//h4[@data-title='Tony Kozlowsky']");
    By NEXT_BUTTON = By.xpath("//button[@class='js-np-next gf-btn btn-primary btn-block btn-lg inline-block']");
    By AWARD_PROGRAM = By.xpath("//div[@class='js-np-award-program-item np-award-program-default np-award-program relative']");
    By AWARD_REASON = By.xpath("//div[contains(@class, '1_bg_color')]");
    By SKIP_AWARD_ADVISOR = By.xpath("//a[@class='js-np-skip-advisor block np-advisor-skip-link award_reason_1_color']");
    By AWARD_TYPE = By.xpath("//div[3]/bdi");
    By AWARD_TITLE = By.xpath("//textarea[@id='np_awardTitle']");
    By AWARD_MESSAGE = By.xpath("//textarea[@id='np_awardMessage']");
    By SEND_AWARD_BUTTON = By.xpath("//button[@class='js-np-send-award gf-btn btn-primary btn-lg btn-block inline-block']");
    By CLOSE_BUTTON = By.xpath("//button[@class='js-np-close gf-btn btn-primary btn-block btn-lg inline-block']");
    By LOG_OUT = By.xpath("//a[@href='/microsites/t/home?logout&client=testclientclone3']");

    By GDPR = By.xpath("//button[@class='btn btn--primary']");
    By COOKIE_ACCEPT = By.xpath("//button[@class='cookie-accept-btn']");
    By HOME_TAB = By.xpath("//a[@href='/microsites/t/home?client=testclientclone3' and @target='_self']");
    By SIGN_IN_BUTTON = By.id("signIn-button");

}
