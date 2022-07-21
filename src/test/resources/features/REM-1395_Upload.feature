@Regression @REM-1412
Feature: As a user, I should be able to upload files and pictures as messages.

  Acceptance Criteria:
    1. User should be able to upload multiple files at the same time (Test with max 3 files.).
    2. User should be able to upload files in different formats.
    3. User should be able to upload pictures.
    4. User should be able to display the uploaded picture itself in Activity Stream.
    5. User should be able to insert the files and images into the text
    6. User should be able to allow a recipient to edit documents.
    7. User should be able to remove files and images at any time before sending.
    8. User should be able to rename the file before sending it.

  Description:
    Supported file formats .pdf, .txt, .jpeg, .gif, .png, .docx

  Background: User should login with valid credentials and be on the homepage.
    Given User is on the homepage
    When User clicks message tab on the quick navigation menu
    And User clicks on the upload files image
  @REM-1413
  Scenario: User should be able to upload multiple same format files at the same time with clicking the upload files and images box.
    And User uploads three same format files with clicking the upload files and images box
    And User clicks send button
    Then User should see the uploaded files as attachments under the related message
  @REM-1414
  Scenario: User should be able to upload multiple different format files one by one with clicking the upload files and images box.
    And User uploads multiple different format files one by one with clicking the upload files and images box
    And User clicks send button
    Then User should see the uploaded files as attachments under the related message
  @REM-1415
  Scenario: User should be able to upload image and display the uploaded image itself in the related message.
    And User uploads image with clicking the upload files and images box
    And User clicks send button
    Then User should see the uploaded image itself in the related message
  @REM-1416
  Scenario: User should be able to insert the files and images into the text.
    And User uploads file and image with clicking the upload files and images box
    And User clicks insert in text button
    And User clicks send button
    Then User should see the inserted file and image in the text of related message
  @REM-1417
  Scenario: User should be able to allow a recipient to edit documents.
    And User uploads file with clicking the upload files and images box
    And User clicks send button
    And User logouts
    And User re-logins with different credentials
    Then User should see the edit hypertext in the related message
  @REM-1418
  Scenario: User should be able to hinder a recipient to edit documents.
    And User uploads file with clicking the upload files and images box
    And User unchecks the Allow a recipient to edit documents?
    And User clicks send button
    And User logouts
    And User re-logins with different credentials
    Then User should not see the edit hypertext in the related message
  @REM-1419
  Scenario: User should be able to remove files and images at any time before sending.
    And User uploads file and image with clicking the upload files and images box
    And User removes file and image by clicking cancel sign
    Then User should not see file and image as attachments
  @REM-1420
  Scenario: User should be able to rename the file before sending it.
    And User uploads file with clicking the upload files and images box
    And User clicks pen sign when hovering over the uploaded file
    And User renames the uploaded file
    And User clicks send button
    Then User should see new name of the uploaded file in the related message







