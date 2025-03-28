Feature:  Tags feature
  @RA_TC_01 @regression @tags
  Scenario Outline: Successful tag creation
    Given User is on login page
    When User enters a username <username> and password <password>
    And User selects organization Vibgeor
    And User is navigated to Dashboard page
    And User navigates into Tag module problem
    And User creates a tag and validates to be anup

    Examples:
      | username                | password     |Anup | bro
      | 9thstage@gonetor.com    | Admin@123    |
