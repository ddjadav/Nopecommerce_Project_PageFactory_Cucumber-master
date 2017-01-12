
Feature: User should buy product successfully

  @dilip
  Scenario: User should be able to Register successfully
    Given I open browser and goto Nopecommerce website
    And I click on register link to open register page
    And I enter register details
    When I click on register button
    Then I see successfully registered message

    @kavya
  Scenario: User should be able to Login  successfully with valid username and password
    Given user open browser and goto Nopecommerce website
    When user click on Login link
    And user enter valid Username and valid Password
    And user click on Login button
    Then user should successfully logged in


