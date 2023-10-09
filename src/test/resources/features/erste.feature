@erste

Feature: Verify that search functionality works as expected

Background:
  Given User login with valid credentials

  Scenario Outline: Positive Test Scenarios
    When User enters "<fashion>" in the search box
    Then user verifies selected category
    Examples:

      | fashion |
      | Fashion |
      | FASHION |
      | fashion |
      | fAshiOn |

  Scenario Outline: Negative Test Scenarios
    When User enters "<fashion>" in the search box
    Then user verifies that selected category is not shown
    Examples:

      | fashion |
      | Fashio  |
      | fAshiO* |



