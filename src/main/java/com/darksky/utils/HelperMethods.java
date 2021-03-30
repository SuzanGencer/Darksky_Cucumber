package com.darksky.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.darksky.base.BasePage.driver;

public class HelperMethods {

    public static String getCurrentURL_HM() {
        try {
            return driver.getCurrentUrl();
        } catch (Exception e) {
            System.out.println("Some exception occurred while getting the url");
            return null;
        }
    }

    public static String getPageTitle_HM() {
        try {
            return driver.getTitle();
        } catch (Exception e) {
            System.out.println("Some exception occurred while getting the title");
            return null;
        }
    }

    public static String getText_HM(WebElement element) {
        try {
            return element.getText();
        } catch (Exception e) {
            System.out.println("Some exception occured while getting the text " + element);
            return null;
        }
    }

    public static boolean isDisplayed_HM(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            System.out.println("Some exception occurred while checking if the element is displayed or not " + element);
            return false;
        }
    }

    public static void sendText_HM(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            System.out.println("Some exception occurred while sending keys at " + element);
        }
    }

    public static WebDriverWait getWaitObject() {
        return new WebDriverWait (driver, Constants.EXPLICIT_WAIT_TIME);
    }

    public static void waitForVisibility(WebElement element) {
        getWaitObject().until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForClickability(WebElement element) {
        getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void doClick_HM(WebElement element) {
        try {
            waitForClickability(element);
            element.click();
        } catch (Exception e) {
            System.out.println("Some exception occurred while clicking at " + element);
        }
    }
}
