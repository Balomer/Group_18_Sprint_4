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


  Scenario: User can add questions and questions
    And user click Add question button 2 times
    Then user displayed added question
    And user click last answer 2 times under the 2 question
    Then user displayed added answer


  Scenario: User can delete question and answers
    And user click x mark near the 3 question
    Then user can not displayed selected question
    And user click x mark near the 2 answer under 2 question
    Then user can not displayed selected answer


  Scenario: User can provide multiple choice by selecting the Allow multiple choice checkbox
    And user click add more link and Employees and Department's tab on the pop-up
    And user select multiple contacts
      | hr101@cybertekschool.com |
    And user enter texts "This is a poll" into text box, "Question" into question box, "Answer 1" into answer one box, "Answer 2" into answer two box
    And user click Allow multiple choice checkbox
    Then attendee user can choice multiple options


  Scenario: User can create a poll with mandatory fields
    And user click add more link and Employees and Department's tab on the pop-up
    And user select multiple contacts
      | hr39@cybertekschool.com |
    And user enter texts "" into text box, "Fruits?" into question box, "Apple" into answer one box, "Orange" into answer two box
    And user click Send button
    Then user displayed "The message title is not specified" error message on the page


  Scenario: User can create a poll with mandatory fields
    And user delete recipients
    And user enter texts "Hello" into text box, "Fruits?" into question box, "Apple" into answer one box, "Orange" into answer two box
    And user click Send button
    Then user displayed "Please specify at least one person." error message on the page


  Scenario: User can create a poll with mandatory fields
    And user click add more link and Employees and Department's tab on the pop-up
    And user select multiple contacts
      | hr39@cybertekschool.com |
    And user enter texts "Hello" into text box, "" into question box, "Apple" into answer one box, "Orange" into answer two box
    And user click Send button
    Then user displayed "Please specify at least one question." error message on the page

    @wip
  Scenario: User can create a poll with mandatory fields
    And user click add more link and Employees and Department's tab on the pop-up
    And user select multiple contacts
      | hr39@cybertekschool.com |
    And user enter texts "Hello" into text box and delete questions
    And user click Send button
    Then user displayed error message and can not send poll as only a text
