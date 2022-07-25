Feature: As a user, I should be able to send messages by clicking on Message tab under Active Stream.

  1. User should be able to send a message by filling in the mandatory fields.
  2. The message delivery should be to 'All employees' by default and should be changeable.
  3. User should be able to cancel sending messages at any time before sending.

  Description:
  > Mandatory fields:  'Message Title'(content) & 'Recipient'.
  >  Error messages for mandatory fields:
  > "The message title is not specified."
  > "Please specify at least one person."
  > Recipients should be selectable from "Recent",
  "My Groups"(enable to see this type of Recipients you need to join at least one of the groups beforehand)
  and "Employees and departments."
  > Recipients can be added more than one and are deletable.

  Background:
    Given logged in successfully with valid credentials and is on home page
@wip
  Scenario:
    When user clicks message tab
    When user specifies a title
    And user specifies a recipient
    Then user is able to send the message

  Scenario:
    When user clicks message tab
    When user doesn't specify a message title and tries to send the message
    Then "The message title is not specified" error message is given

  Scenario:
    When user clicks message tab
    When user doesn't specify a recipient and tries to send the message
    Then "Please specify at least one person." error is given

  Scenario:
    When user clicks message tab
    When user verify 'All employees' is selected as recipient by default
    And verify user can change the default recipient.

  Scenario:
    When user clicks message tab
    And user clicks add more
    And user selects from Recent
    And user selects from My groups
    Then user selects from Employees and departments
    Then user can delete a recipient by clicking the cross sign at the selected recipient



  Scenario:
    When user clicks message tab
    And user specifies a message title
    And user specifies a recipient
    Then user closes recipient select window
    When user cancel sending messages at any time before sending by clicking cancel button