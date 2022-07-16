Feature: As a user, I should be able to add link, insert video, mention, quote, add tag in message.

  #1. User should be able to add mentions about only department employees.
  #2. User should be able to attach a link to the specified text.
  #3. User should be able to insert YouTube and Vimeo videos.
  #4. User should be able to cancel links and videos before sending the message
  #5. User should be able to add quotes.
  #6. User should be able to add tags to messages.
  #7. User should be able to remove tags before sending the message
  
  Background: User should login with valid credentials and be on the homepage.
  Given User is on the homepage 

  @addMention
  Scenario: As a user I should be able to add mentions about only department employees.
    Given user clicks on message or sends message text
    When user clicks on add mention button below the message section
    And user is able to click on Employees and departments module
    And user is able to click on the send button
    Then verify that the message is displayed on the screen



  #Scenario: As a user I should be able to attach a link to the specified text.
  #    Given user should be able to click on message or send message text
  #    When user should be able to click on add mention button below the message section

