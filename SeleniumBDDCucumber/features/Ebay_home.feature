Feature: Ebay Home Page Scenarios

  @P1
  Scenario: Advanced Search Link
    Given I am on Ebay Home Page
    When I click on Advanced Link
    Then I Navigate to Advanced Search Page

  @P7
  Scenario: Search an item in category
    Given I am on Ebay Home Page
    When I search for 'Soap' in 'baby' category

  @P400
  Scenario Outline: Home Page links
    Given I am on Ebay Home Page
    Then I click on '<links>'
    Then I validate that page navigates to '<url>' and title contains '<title>'

    Examples: 
      | links   | url                                                  | title            |
      | Fashion | https://www.ebay.com/b/Fashion/bn_7000259856         | Dress to impress |
      | Sports  | https://www.ebay.com/b/Sporting-Goods/888/bn_1865031 | Sporting         |
