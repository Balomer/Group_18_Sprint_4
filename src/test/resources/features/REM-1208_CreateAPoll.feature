Feature: As a user, I should be able to create a poll by clicking on Poll tab under Active Stream.

  Acceptance Criteria:
  1. User should be able to add users by selecting multiple contacts from Employees and Department's contact lists.
  2. User should be able to add questions and multiple answers.
  3. User should be able to delete questions and multiple answers.
  4. User should be able to provide multiple choice to attendees by selecting the Allow multiple choice checkbox.
  5. User should be able to create a poll with mandatory fields.

  Description:
  Mandatory fields: Message title, recipient, 1 question, 2 answers -
  Error message: "The message title is not specified"
  Error message: "Please specify at least one person."
  Error message: "Please specify at least one question."
  Error message: "Please specify at least two answers."

  Background: user should be able to login home page.
    Given user can login the page
    When user click poll tab


  Scenario: User can add users by selecting multiple contacts from Employees and Department's contact lists.
    And user click add more link and Employees and Department's tab on the pop-up
    And user select multiple contacts
      | hr39@cybertekschool.com       |
      | helpdesk22@cybertekschool.com |
      | Yasinak                       |
    Then user displayed selected contacts in the To section
      | hr39@cybertekschool.com       |
      | helpdesk22@cybertekschool.com |
      | Yasinak                       |

  @wip
    Scenario: User can add questions
      And user click Add question button 2 times
      Then user displayed 2 added question
