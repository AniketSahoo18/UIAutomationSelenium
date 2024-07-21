
@tag
Feature: Purchase the Order from Ecommerce
  I want to use this template for my feature file

	Background:
	Given I landed on Ecommerce page

  @tag2
  Scenario Outline: Test for Submitting Order
    Given Logged in with <UserName> and <Password>
    When I add product <Product> to Cart
    And Checkout <Product> and Submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed in Confirmation page

    Examples:
    
      | UserName  								| Password 		| Product  				|
      | aniketsahoo1998@gmail.com | Aniket@1998 | ZARA COAT 3 		|
      | ketanisahoo1998@gmail.com | Ketani@1998 | ADIDAS ORIGINAL	|
