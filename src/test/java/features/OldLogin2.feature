Feature: Login to the application

  @Sanity @Smoke @Reg
  Scenario: Validate login funcationality of the application
    Given User is on login page with "https://admin-demo.nopcommerce.com/"
    When User enters "admin@yourstore.com"
    And User enters password as "admin"
    And User click on login button
    Then User lands on DashBoard page
    And User close the Browser
