Feature: Login to the application

@Sanity @Smoke @Reg 
Scenario: Validate login funcationality of the application

Given User is on login page
When User enters email
And User enters password
And User click on login button
Then User lands on DashBoard page
And User close the Browser
