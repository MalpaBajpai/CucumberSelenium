#Author: malpa.bajpai1@gmail.com
#Date: 29 March 2022

Feature: Login to Amazon application

  Scenario Outline: Check login functionality
    Given User want to launch the application
    And I wil verify if application launched sucessfully
    When I enter <username> and <password>
    And I click on login button
    Then I validate login email address

    Examples: 
      | username | password  |
      | name1    | password1 |
