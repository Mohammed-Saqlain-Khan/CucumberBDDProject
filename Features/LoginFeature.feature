
Feature: Login

@sanity
  Scenario Outline: User succussfully logged in with valid credentials

    Given User Launch The chrome browser
    When User navigates to the URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And User enter the UserName "<email>" and  password "<password>"
    And User click on login link
    Then Page URL should be "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"
    When click on logout link
    Then Page URL should be "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And Close the browser

    Examples:

    |email|password|
    |Admin|admin123|
    |Admin|saqlain  |
    |admin|admin    |



