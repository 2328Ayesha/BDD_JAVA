Feature: Login to facebook

  Scenario: Login to Facebook with valid credentials
    Given User is on Login Page
    When User Enter EmailID
    And User Enter Password
    And User Click on Login button
    Then User should be on HomePage
    And User closes browser
    And User send number "50"

  Scenario: Login to Facebook with given credentials
    Given User is on Login Page
    When User Enter "asdf@gmail.com" as EmailID
    And User Enter "abc@123" as Password
    And User Click on Login button
    Then User should be on HomePage
    And User closes browser

  Scenario: Login to Facebook with given credentials
    Given User is on Login Page
    When User Enter credentials email and password
      | asdf@gmail.com | abc@123 |
      | sbk@gmail.com  | dfg@123 |
      | ghj@gmail.com  | ijh@123 |
      | eru@gmail.com  | hjk@123 |
    And User Click on Login button
    Then User should be on HomePage
    And User closes browser

  Scenario Outline: Login to Facebook with valid credentials
    Given User is on Login Page
    When User Enter '<EmailID>' as EmailID
    And User Enter '<Password>' as Password
    And User Click on Login button
    Then User should be on HomePage
    And User closes browser

    Examples: 
      | EmailID         | password   |
      | asdf@gmail.com  | abc@123    |
      | sbk@gmail.com   | dfg@123    |
      | qhjf@gmail.com  | ijh@111    |
      | ssss@gmail.com  | jjj@000    |
      
      
