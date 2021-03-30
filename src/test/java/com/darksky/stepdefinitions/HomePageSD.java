package com.darksky.stepdefinitions;

import com.darksky.base.ConfigReader;
import com.darksky.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomePageSD {

    @Given("^I am on the home page$")
    public void verifyHomePageTitle() {
        String expectedTitle = "Dark Sky - 1 City Hall, New York, NY";
        Assert.assertEquals(expectedTitle, HomePage.verifyTitle());
    }

    @When("I enter my location")
    public void enterMyLocation() {
        HomePage.enterLocation(ConfigReader.getProperty("location"));
    }

    @And("I click on the search button")
    public void clickOnTheSearchButton() {
        HomePage.clickSearchBtn();
    }

    @Then("I see the lowest temp")
    public void seeTheLowestTemp() {
        Assert.assertTrue(HomePage.isVisibleLowTemp());
    }


    @Then("I see the highest temp")
    public void seeTheHighestTemp() {
        Assert.assertTrue(HomePage.isVisibleHighTemp());
    }
}
