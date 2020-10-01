Feature: To Test the CartManagementSystem Application

Scenario: To Test the Login Function of CartManagementSystem
    Given To launch the browser and Navigate to the Url
    When To Enter Username and Password
    Then To Click the Submit button
    But If Login fails give warning message
    Then To Take the Screenshot and the Title

Scenario: To Add and Remove item 
    Then To Click the Add To Cart Button
    Then To Remove the Add From Cart
    Then Close the browser
