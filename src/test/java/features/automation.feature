Feature: Ralvie onboarding
  @A
  Scenario: verify whether successful login happens
    Given User is in login page
    When User logins to the application
    And User selects company
    Then User redirects into dashboard page
