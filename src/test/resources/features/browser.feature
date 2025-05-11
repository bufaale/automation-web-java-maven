@Browser
Feature: Browser

  Scenario: Switch to new tab and return
    Given the user navigates to "https://www.google.com"
    And the tab title should contain "Google"
    When the user opens a new tab with "https://www.wikipedia.org"
    And they switch to tab 1
    Then the tab title should contain "Wikipedia"
    When they close the current tab and switch back
    Then the tab title should contain "Google"
