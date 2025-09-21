Feature: Ebay Home Page Scenarios

  @P1 @setCookies @Test
  Scenario: Advance Search Link

    Given Iam on Ebay Home Page
    When I click on Advance Link
    Then I navigate to Advance search page

  @P2 @P6
  Scenario: Search items count

    Given Iam on Ebay Home Page
    When I search for "iPhone11"
     Then I validate atleast 100 search items present

  @P3
  Scenario: Search items count

    Given Iam on Ebay Home Page
    When I search for "Toy Cars"
    Then I validate atleast 100 search items present

  @P35
  Scenario: Search an item in category
    Given Iam on Ebay Home Page
    When I search for "soap" in "Baby" category

  @P356
  Scenario Outline: Home Page links
    Given Iam on Ebay Home Page
    When I click on '<link>'
    Then I validate that page navigates to '<url>' and title contains '<title>'
    Examples:
      | link    | url                                                          | title                                     |
      | Fashion | https://www.ebay.com/b/Fashion/bn_7000259856                 | Fashion \| eBay                           |
      | Sports  | https://www.ebay.com/b/Sporting-Goods/888/bn_1865031         | Sporting Goods \| eBay                    |
