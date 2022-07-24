Feature: CRMLY Event Tab Functionality

User Story: As a user, I should be able to create events by clicking on Event tab under Activity Stream.

  Acceptance Criterias:
  AC #1. User should be able to add Event start and ending date and time, select "All day" and specify the time zone.
  AC #2. User should be able to set reminder.
  AC #3. User should be able to select the event location from the dropdown.
  AC #4. User should be able to add members by selecting contacts individually or adding groups and departments.
  AC #5. User should be able to send event by filling the mandatory fields.
  AC #6. User should be able to cancel sending event at any time before sending.

  Description:
  1. Mandatory fields: Event Name
  2. Today's date should default as start date and end date

  Background: The user logs into the application and clicks on the event module.
    Given User logged in to the homepage and clicked Calender from menu

    Scenario: User should be able to add Event start and ending date and time, select "All day" and specify the time zone.
      When User click to add on the Event tab
      And User should be able to select "All Day"
      And User should be specify time zone.

    Scenario: User should be able to set reminder.
      When User click to add on the Event tab
      And User should be able to select Reminder
      Then User should click to Save button

    Scenario:User should be able to select the event location from the dropdown.
      When User click to add on the Event tab
      And User should be able to access location dropdown
      Then User should be able to select event location

    Scenario: User should be able to add members by selecting contacts individually or adding groups and departments.
      When User click to add on the Event tab
      And User should be able to add members
      Then User should be contact adding group and departments

     Scenario:User should be able to send event by filling the mandatory fields.
       When User click to add on the Event tab
       And User should be able to filling the Event name
       Then User should be able to filling start and end date
       And User should click to Save button

     Scenario: User should be able to cancel sending event at any time before sending.
      When User should be able to add on the Event tab
       And User should be able to create new event
       Then User should be able to click Cancel button



