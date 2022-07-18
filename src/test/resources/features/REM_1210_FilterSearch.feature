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
