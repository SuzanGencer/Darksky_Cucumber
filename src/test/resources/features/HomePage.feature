@Temp
Feature: Darksky Temp
  Scenario: Verify the lowest and highest temp
    Given I am on the home page
    When I enter my location
    And I click on the search button
    Then I see the lowest temp
    Then I see the highest temp