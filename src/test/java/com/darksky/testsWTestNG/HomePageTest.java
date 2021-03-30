package com.darksky.testsWTestNG;

import com.darksky.base.BasePage;
import com.darksky.base.ConfigReader;
import com.darksky.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest {

    @BeforeMethod
    public void setUp() {
        BasePage.initDriver();
        HomePage.enterLocation(ConfigReader.getProperty("location"));
        HomePage.clickSearchBtn();
    }

    @Test
    public void seeTheLowestTemp() {
        Assert.assertTrue(HomePage.isVisibleLowTemp());
    }

    @Test
    public void seeTheHighestTemp() {
        Assert.assertTrue(HomePage.isVisibleHighTemp());
    }

    @AfterMethod
    public static void quit(){
        BasePage.tearDown();
    }
}
