@REM-1437
Feature: As a user, I should be able to create a poll by clicking on Poll tab under Active Stream.

	Background:
		#@REM-1427
		Given user can login the page
		When user click poll tab
		

	#As a user, I should be able to create a poll by clicking on Poll tab under Active Stream.
	#
	# # User should be able to add users by selecting multiple contacts from Employees and Department's contact lists.
	# # User should be able to add questions and multiple answers.
	# # User should be able to delete questions and multiple answers.
	# # User should be able to provide multiple choice to attendees by selecting the Allow multiple choice checkbox.
	# # User should be able to create a poll with mandatory fields.
	#
	# * *Mandatory fields:* Message title, recipient, 1 question, 2 answers -
	# * *Error message:* "The message title is not specified" 
	# * *Error message:* "Please specify at least one person." 
	# * *Error message:* "Please specify at least one question." 
	# * *Error message:* "Please specify at least two answers."
	@REM-1428
	Scenario: User can add users by selecting multiple contacts from Employees and Department's contact lists.
		And user click add more link and Employees and Department's tab on the pop-up
		    And user select multiple contacts
		      | hr39@cybertekschool.com       |
		      | helpdesk22@cybertekschool.com |
		      | Yasinak                       |
		    Then user displayed selected contacts in the To section	


	@REM-1429
	Scenario: User can add questions and questions
		And user click Add question button 2 times
		    Then user displayed added question
		    And user click last answer 2 times under the 2 question
		    Then user displayed added answer	


	@REM-1430
	Scenario: User can delete question and answers
		And user click x mark near the 3 question
		    Then user can not displayed selected question
		    And user click x mark near the 2 answer under 2 question
		    Then user can not displayed selected answer	


	@REM-1431
	Scenario: User can provide multiple choice by selecting the Allow multiple choice checkbox     And
		And user click add more link and Employees and Department's tab on the pop-up
		    And user select multiple contacts
		      | hr101@cybertekschool.com |
		    And user enter texts "This is a poll" into text box, "Question" into question box, "Answer 1" into answer one box, "Answer 2" into answer two box
		    And user click Allow multiple choice checkbox
		    Then attendee user can choice multiple options	


	@REM-1432
	Scenario: User can create a poll with mandatory fields
		And user click add more link and Employees and Department's tab on the pop-up
		    And user select multiple contacts
		      | hr39@cybertekschool.com |
		    And user enter texts "" into text box, "Fruits?" into question box, "Apple" into answer one box, "Orange" into answer two box
		    And user click Send button
		    Then user displayed "The message title is not specified" error message on the page	


	@REM-1433
	Scenario: User can create a poll with mandatory fields
		And user delete recipients
		    And user enter texts "Hello" into text box, "Fruits?" into question box, "Apple" into answer one box, "Orange" into answer two box
		    And user click Send button
		    Then user displayed "Please specify at least one person." error message on the page	


	@REM-1434
	Scenario: User can create a poll with mandatory fields
		And user click add more link and Employees and Department's tab on the pop-up
		    And user select multiple contacts
		      | hr39@cybertekschool.com |
		    And user enter texts "Hello" into text box, "" into question box, "Apple" into answer one box, "Orange" into answer two box
		    And user click Send button
		    Then user displayed "Please specify at least one question." error message on the page	


	@REM-1435
	Scenario: User can create a poll with mandatory fields
		And user click add more link and Employees and Department's tab on the pop-up
		    And user select multiple contacts
		      | hr39@cybertekschool.com |
		    And user enter texts "Hello" into text box and delete questions
		    And user click Send button
		    Then user displayed "Please specify at least one question." error message and can not send poll as only a text	


	@REM-1436
	Scenario: User can create a poll with mandatory fields
		And user click add more link and Employees and Department's tab on the pop-up
		    And user select multiple contacts
		      | hr39@cybertekschool.com |
		    And user enter texts "Hello" into text box, "Fruit?" into question box, "Apple" into answer one box, delete second answer
		    And user click Send button
		    Then user displayed "Please specify at least two answers." error message and can not send poll with one answer
