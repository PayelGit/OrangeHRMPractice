Feature:  Login feature
  @RA_TC_01 @regression @login
  Scenario Outline: Successful login with valid credentials
    Given User is on login page
    When User enters a username <username> and password <password>
    And User selects organization
    Then User is navigated to Dashboard page

    Examples:
      | username                | password     |
      | 9thstage@gonetor.com    | Admin@123    |
      | marybel0@promoteion.com | Admin@123    |

  @RA_TC_02 @regression
  Scenario Outline: Login with invalid credentials
    Given User is on login page
    When User enters a username <username> and password <password>
    Then User receives error message
    And User should remain on the login page

    Examples:
      | username                | password     |
      | 9thstage@gonetor.com    | Wrong@1pass  |
      | 9thstage@gonetor.comm   | Admin@123    |
#      |                         |              |
