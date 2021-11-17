Feature: Qualitest Demo test for adding lowest product item

  Scenario Outline:  Verify lowest product item out of the four items in wishlist is added in cart
		Given I add "<count>" different products to my wishlist
		When I view my wishlist table
		Then I find total four selected items in my wishlist
		When I search for lowest price product
		And I am able to add the lowest price item to my cart
		Then I am able to verify the item in my cart
		
		Examples:
		| count |
		| 4		|
    
  