Feature: Hadnling data from feature file

  Scenario: Handling data from feature file
    Given User login to "https://admin-demo.nopcommerce.com/" with "admin@yourstore.com" and "admin"
    When User handles datatable with header
      | Sr. no. | Email                | password |
      |      01 | admin1@yourstore.com | admin1   |
      |      02 | admin2@yourstore.com | admin2   |
      |      03 | admin3@yourstore.com | admin3   |
    And User handles datatable without header
      | Dashboard          |
      | Catalog            |
      | Sales              |
      | Customers          |
      | Promotions         |
      | Content management |
      | Configuration      |
      | System             |
      | Reports            |
      | Help               |

  @Practice
  Scenario Outline: Handling data from example table #execute in cycle
    Given User handles exmaple table
    Then User enter '<email>' and '<password>'

    Examples: 
      | email                | password |
      | admin1@yourstore.com | admin1   |
      | admin2@yourstore.com | admin2   |
      | admin3@yourstore.com | admin3   |
