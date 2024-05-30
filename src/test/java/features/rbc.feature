@wip
Feature: Amazon Login

  Scenario: Logo present on Amazon home page
    Given User launch chrome browser
    When User opens Amazon URL
    Then Verify logo present in Amazon homepage
    Then Close browser