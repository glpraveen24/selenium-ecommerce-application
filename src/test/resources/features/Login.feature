Feature: User Login Functionality

  Background: Navigate to Login Page
    Given The user navigates to the e-commerce website
    When The user clicks on the Log in link
    Then The user should be on the login page

  Scenario Outline: Successful Login with Valid Credentials
    When The user enters valid email "<email>"
    And The user enters valid password "<password>"
    And The user clicks the Log in button
    Then The user should be successfully logged in

    Examples:
      | email                     | password     |
      | glalithapraveen@gmail.com | Praveen@123  |
      | glalithapraveen@gmail.com | Praveen$7852 |
    
