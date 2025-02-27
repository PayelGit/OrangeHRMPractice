Feature:  Tags feature
  @RA_TC_01 @regression @tags
  Scenario Outline: Successful tag creation
    Given User is on login page
    When User enters a username <username> and password <password>
    And User selects organization
    And User is navigated to Dashboard page
    And User navigates into Tag module
    And User creates a tag and validates

    Examples:
      | username                | password     |
      | 9thstage@gonetor.com    | Admin@123    |