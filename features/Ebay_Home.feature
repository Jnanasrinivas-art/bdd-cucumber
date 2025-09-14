Feature: Ebay Home Page Scenarios

  @P1
  Scenario: Advance Search Link

    Given Iam on Ebay Home Page
    When I click on Advance Link
    Then I navigate to Advance search page

    @P2
  Scenario: Search items count

    Given Iam on Ebay Home Page
    When I search for "iPhone11"
    Then I validate atleast 1000 search items present

  @P3
  Scenario: Search items count

    Given Iam on Ebay Home Page
    When I search for "Toy Cars"
    Then I validate atleast 100 search items present

    @P35
    Scenario: Search an item in category
      Given Iam on Ebay Home Page
      When I search for "soap" in "Baby" category