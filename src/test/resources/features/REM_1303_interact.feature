@fatih
Feature: As a user, I should be able to interact with employees on the posts.

  1. User should be able to make a comment, like, or unfollow other employees' posts.
  2. User should be able to like, or make comments on all other reviewers' comments.
  3. User should be able to like and reply his/her own comment.
  4. After making a comment user should be able to "view comment", "copy link", "edit",
     "delete" and "create task" by clicking more
  5. User should be able to see the reviewers' names and visit their profiles by clicking
     on reviewers' name
  6. User should be able to add others' posts to favorites by clicking on the Star icon.


  Background: User should login with valid credentials and be on the homepage.
    Given User is successfully on the homepage

  Scenario: 1. User should be able to make a comment, like, or unfollow other employees' posts.
    When After clicking comment button, user write a "comment" and click send button
    Then User should see own comment on the post
    When User click like button
    Then User should see like sign on the post
    When User click unfollow button
    Then User should unfollow the post.

  Scenario: 2. User should be able to like, or make comments on all other reviewers' comments.
    When User click comment like button
    Then User should be able to see like icon on the comment.
    When User click comment reply button
    And User writes "comment reply" and click send button
    Then User should be able to make comments other reviewers' comments.

  Scenario: 3. User should be able to like and reply his/her own comment.
    When After clicking comment button, user write a "my own comment" and click send button
    When User click own comment's like button
    Then User should be able to see like icon on own the comment.
    When User click own comment reply button
    And User writes "my own comment reply message" and click send button
    Then User should be able to make comments his own comments.

    Scenario: 4. After making a comment user should be able to "view comment", "copy link", "edit",
    "delete" and "create task" by clicking more
      When User click more button under the his own comment.
      And User click view comment.
      Then User should be able to view his own comment.
      When User click more button under the his own comment.
      And User click copy link button.
      Then User should be able to copy the link.
      When User click more button under the his own comment.
      And User click edit button.
      And User writes "new " on the comment box and click send button.
      Then User should be able to edit his comment.
      When User click new more button under the his own comment.
      And User click create task button.
      Then User should be able to create task.
      When User click new more button under the his own comment.
      And User click delete button.
      Then User should be able to delete his own comment.

      Scenario: 5. User should be able to see the reviewers' names and visit their profiles by clicking
      on reviewers' name
        When User click reviewers' button
        And User click reviewers' name
        Then User should be able to see reviewers' profile

      Scenario: 6. User should be able to add others' posts to favorites by clicking on the Star icon.
        When User click star icon
        Then User should be able to add others' posts to favorites

