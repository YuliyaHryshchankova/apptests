package com.company.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);

    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public boolean isElementPresent(By by) {
        int i = driver.findElements(by).size();
        return i != 0;
    }


    public boolean isElementPresent(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException nsee) {
            return false;
        }
    }


    protected WebElement waitElementToBeClickable(WebElement webElement) {
        return new WebDriverWait(driver, 20)
                .pollingEvery(Duration.ofSeconds(1))
                .withMessage("Failed to wait element: " + webElement)
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected WebElement waitElementToBeClickable(final By by) {
        return new WebDriverWait(driver, 20)
                .pollingEvery(Duration.ofSeconds(1))
                .withMessage("Failed to wait element: " + by)
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    protected void waitElementInvisible(final By by) {
        new WebDriverWait(driver, 20)
                .pollingEvery(Duration.ofSeconds(1))
                .withMessage("Failed to wait element: " + by)
                .until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    protected void waitElementInvisible(WebElement webElement) {
        new WebDriverWait(driver, 20)
                .pollingEvery(Duration.ofSeconds(1))
                .withMessage("Failed to wait element: " + webElement)
                .until(ExpectedConditions.invisibilityOf(webElement));
    }


}