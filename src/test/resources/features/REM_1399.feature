Feature: As a user, I should be able to assign tasks under Quick Navigate Menu
  1. HR User should be able to create a "High priority" tasks with the mandatory fields.
  2. HR User should be able to assign a task to more than one user (Test with adding 3 users max.)
  3. When task(s) is(are) created, they can be seen on the count on the homepage under "MY TASKS" table.
  4. Checklist should be able to be added while creating a task.
  5. Deadline should be able to be added while creating a task.
  6. Time planning function should be able to be used in the setting of deadline.

  Mandatory fields: Task name, Responsible person
  Error message:  "The task name is not specified."
  Error message: "A user specified in the field "Responsible Person" was not found."

  Background: User should login with valid credentials and be on the homepage.
    Given User is on the homepage

Scenario: Verify HR user can create a "High priority" tasks with the mandatory fields.
  When user click new task
  And user enter "task name"
  And user click high priority checkbox
  And user click add task button
  Then user should see new task "task name" and priority image in the task list

Scenario:  HR User can assign a task to more than one user
  When user click new task
  And user enter "task name"
  And user click add more button and enter mails
    |hr60@cybertekschool.com|
    |hr59@cybertekschool.com|
    |hr58@cybertekschool.com|
  And user click add task button
  And user click "task name" on the task list
  Then user should see all responsibles mails in the task
    |hr60@cybertekschool.com|
    |hr59@cybertekschool.com|
    |hr58@cybertekschool.com|

Scenario: Once task(s) is(are) created, they can be seen on the count on the homepage under "MY TASKS" table.
  When user looks ongoing count on My Tasks
  And user click new task
  And user enter "task name"
  And user click add task button
  Then user should see new count in myTaskTable

Scenario: Checklist can add while creating a task.
  When user click new task
  And click and add "checklist"
  Then user should see "checklist"

Scenario: Deadline can add while creating a task.
  When user click new task
  And click time deadline inputbox
  Then user should see deadline

Scenario: Time planning function should be able to be used in the setting of deadline.
  When user click new task
  And click time planning button
  And user enter start task on and duration as a "time"
  Then user should see "deadline"