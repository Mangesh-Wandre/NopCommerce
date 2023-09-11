Feature: Login to the application

  @Sanity @Smoke @Reg @Test
  Scenario: Validate login funcationality of the application
    Given User is on login page with "https://admin-demo.nopcommerce.com/"
    When User enters "admin@yourstore.com"
    And User enters password as "admin"
    And User click on login button
    Then User lands on DashBoard page
    And Validate the menu items
      | Catalog            |
      | Dashboard          |
      | Sales              |
      | Customers          |
      | Promotions         |
      | Content management |
      | Configuration      |
      | System             |
      | Reports            |
      | Help               |
    And User close the Browser
