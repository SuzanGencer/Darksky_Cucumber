package com.darksky.pages;

import com.darksky.utils.HelperMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.darksky.base.BasePage.driver;

public class HomePage {

    @FindBy(xpath = "//form[@id='searchForm']/input")
    public static WebElement location;

    @FindBy(xpath = "//img[@alt='Search Button']")
    public static WebElement searchBtn;

    @FindBy(xpath = "//span[contains(text(),'Low:')]")
    public static WebElement lowTemp;

    @FindBy(xpath = "//span[contains(text(),'High:')]")
    public static WebElement highTemp;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public static String verifyTitle() {
        return HelperMethods.getPageTitle_HM();
    }

    public static void enterLocation(String loc) {
        HelperMethods.sendText_HM(location, loc);
    }

    public static void clickSearchBtn() {
        HelperMethods.doClick_HM(searchBtn);
    }

    public static boolean isVisibleLowTemp() {
        return HelperMethods.isDisplayed_HM(lowTemp);
    }

    public static boolean isVisibleHighTemp() {
        return HelperMethods.isDisplayed_HM(highTemp);
    }

}
