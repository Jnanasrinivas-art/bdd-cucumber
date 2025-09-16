Feature: Ebay Advances Search Page

  @P24
  Scenario: Ebay Logo on Advanced Search Page

    Given Iam on EBay Advanced Search Page
    When I click on EBay Logo
    Then Iam navigated to EBay Home Page

    @P39
  Scenario: Advance search on item
    Given Iam on EBay Advanced Search Page
    When I advanced search an item
      | keyword   | exclude     | min | max |
      | i Phone11 | refurbished | 300 | 900 |