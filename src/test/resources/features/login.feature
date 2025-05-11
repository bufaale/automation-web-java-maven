Feature: Login

  Scenario: Valid login
    Given the user navigates to the login page
    When they enter username "tomsmith" and password "SuperSecretPassword!"
    Then they should see the message "You logged into a secure area!"

  Scenario: Invalid login
    Given the user navigates to the login page
    When they enter username "tomsmith" and password "incorrecto"
    Then they should see the message "Your password is invalid!"

  Scenario: Successful login leads to dashboard
    Given the user navigates to the login page
    When they enter username "tomsmith" and password "SuperSecretPassword!"
    Then they should see the message "You logged into a secure area!"
    And the dashboard should display the title "Secure Area"

