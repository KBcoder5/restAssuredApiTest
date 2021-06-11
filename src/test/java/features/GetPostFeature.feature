Feature: verify different GET operations using RestAssured

  Scenario: validate value from the get operation body i:e author
    Given when we perform the GET operation
    When sends the sub parameter as number "1"
    Then author name be visible as "Karthik KK"