Feature: To Validate Login Functionality of Flipkart Application

  #Background: 
    #Given The User Should be in Flipkart Login Page

  Scenario Outline: To validate the login Functionality with invalid details
    Given The User Should be in Flipkart Login Page
    When The User has to Fill MobileNumber "<Username>" and Password "<Password>"
    And The User Has to Click Login
    Then It show Error Message for invalid mobilenumber or password

    Examples: 
      | Username   | Password   |
      | 1234567890 | 9988776655 |

  
  Scenario Outline: To validate the login Functionality with valid details
    Given The User Should be in Flipkart Login Page
    When The User has to Fill MobileNumber "<username>" and Password "<password>"
    And The User Has to Click Login
    Then It show Error Message for valid mobilenumber or password

    Examples: 
      | username   | password   |
      | 9159162176 | 9876543210 |
