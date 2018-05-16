package com.company.test.utils;

import org.openqa.selenium.By;

public class Constants {

    public static final By NOMINATE_AS_MYSELF_BUTTON = By.xpath("//button[@class='js-np-recipient-item gf-btn btn-primary btn-lg']");
    public static final By NOMINEE = By.xpath("//ul[@class='np-recipient-list list-unstyled clearfix']//h4[@data-title='Tony Kozlowsky']");
    public static final By NEXT_BUTTON = By.xpath("//button[@class='js-np-next gf-btn btn-primary btn-block btn-lg inline-block']");
    public static final By AWARD_PROGRAM = By.xpath("//div[@class='js-np-award-program-item np-award-program-default np-award-program relative']");
    public static final By AWARD_REASON = By.xpath("//div[contains(@class, '1_bg_color')]");
    public static final By SKIP_AWARD_ADVISOR = By.xpath("//a[@class='js-np-skip-advisor block np-advisor-skip-link award_reason_1_color']");
    public static final By AWARD_TYPE = By.xpath("//div[3]/bdi");
    public static final By AWARD_TITLE = By.xpath("//textarea[@id='np_awardTitle']");
    public static final By AWARD_MESSAGE = By.xpath("//textarea[@id='np_awardMessage']");
    public static final By SEND_AWARD_BUTTON = By.xpath("//button[@class='js-np-send-award gf-btn btn-primary btn-lg btn-block inline-block']");
    public static final By CLOSE_BUTTON = By.xpath("//button[@class='js-np-close gf-btn btn-primary btn-block btn-lg inline-block']");
}
