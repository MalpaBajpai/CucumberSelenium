Feature: feature to test google search functionality

  Scenario: Check login functionality
    Given browser is open
    And user is on google search page
    When user enters the text in search textbox
    And user press enter
    Then user navigates to search result
    And user closes the browser