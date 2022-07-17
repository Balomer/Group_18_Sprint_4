Feature: As a user, I should be able to assign tasks under Quick Navigate Menu

  Background: Login and click message button
    Given user already login
    And user click tasks button on quick navigate menu

Scenario: Verify HR user can create a "High priority" tasks with the mandatory fields.
  When user click new task
  And user enter "task name"
  And user click high priority checkbox
  And user click add task button
  Then user should see new task "task name" and priority image in the task list

Scenario:  HR User can assign a task to more than one user
  When user click new task
  And user enter "task name"
  And user click add more button and enter "mails"
  |hr60@gmail.com|
  And user click add task button
  And user click "task name" on the task list
  Then user should see all responsibles "mails" in the task

Scenario: Once task(s) is(are) created, they can be seen on the count on the homepage under "MY TASKS" table.
  When user click new task
  And user enter "task name"
  And user click add task button
  Then user should see new count "task name" in myTaskTable

Scenario: Checklist can add while creating a task.
  When user click new task
  And user enter "task name"
  And click and add "checklist"
  And user click add task button
  Then user should see "checklist"

Scenario: Deadline can add while creating a task.
  When user click new task
  And user enter "task name"
  And click time "deadline" inputbox
  And user enter start task on and duration as a "time"
  Then user should see "deadline"

Scenario: Time planning function should be able to be used in the setting of deadline.
  When user click new task
  And user enter "task name"
  And click time planning button
  And user enter start task on and duration as a "time"
  Then user should see "deadline"