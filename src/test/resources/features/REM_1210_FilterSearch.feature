Feature: "Filter and search" functionality on Active Stream.
  As a user, I should be able to use "Filter and search" functionality on Active Stream

  Background: User should login with valid credentials and be on the homepage.
    Given User is on the homepage

  @REM-1401
  Scenario: User should be able to see default filters as "my activity, work, favorites, announcements, and workflows"
    When user clicks on the filter and search box
    And user clicks on the edit gear
    And user clicks on the reset to default module
    And user clicks the continue button on the pop-up message
    Then user sees default filters as
      | WORKFLOWS     |
      | ANNOUNCEMENTS |
      | MY ACTIVITY   |
      | FAVORITES     |
      | WORK          |


  @REM-1402
  Scenario: User should be able to add and remove fields
    When user clicks on the filter and search box
    And user clicks on the add file module
    And user clicks on the date field
    Then the date input box is added
    And user clicks on the delete icon
    Then the date input box is removed

  @REM-1423
  Scenario: User should be able to search by specifying the Date
    When user clicks on the filter and search box
    And user clicks on the date input box
    And user selects date
    And user clicks on the search button
    Then the selected date should be displayed on the filter and search box

  @REM-1411
  Scenario: User should be able to save the filter.
    When user clicks on the filter and search box
    And user clicks on the save filter module
    And user enters filter "EMRE"
    And user clicks on the save button
    Then the provided filter name "EMRE" should be displayed under the filters


