@REM-1210
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

  @REM-1424
  Scenario: User should be able to search by selecting single or multiple types
    When user clicks on the filter and search box
    And user clicks on the type input box
    And user selects single type as "Posts"
    And user clicks on the search button
    Then the selected type "Posts" should be displayed on the filter and search box
    And user deletes the "Posts"
    When user clicks on the filter and search box
    And user clicks on the type input box
    And user selects multiple types as
      |Posts|
      |Announcements|
    And user clicks on the search button
    Then the selected types should be displayed on the filter and search box
      |Posts|
      |Announcements|



  @REM-1425
  Scenario: User should be able to restore the default field
    When user clicks on the filter and search box
    And user deletes the date input box, type input box, author input box, to input box
    And user clicks on the restore default fields
    Then the default fields should be visible

  @REM-1441
  Scenario: User should be able to reset filters to default
    When user clicks on the filter and search box
    And user clicks on the date input box
    And user selects date
    And user clicks on the type input box
    And user selects single type as "Posts"
    And user clicks on the reset button
    Then the default fields should be visible



