package stepDefinition;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Parameters;
import webpages.CartPage;
import webpages.CheckoutPage;
import webpages.ConfirmationPage;
import webpages.HomePage;
import webpages.LandingPage;

public class StepDefinitionImpl extends Parameters {
	
	LandingPage landPage;
	HomePage homePage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	ConfirmationPage confPage;

	@Given("I landed on Ecommerce page")
	public void landed_on_Ecommerce_page() {

		propLoad();
		setUp();
		
		landPage = new LandingPage(driver);

		landPage.launchApp(driver);
	}

	@Given("^Logged in with (.+) and (.+)$")
	public void logged_in_username_and_password(String username, String password) {
		
		homePage = landPage.loginApplication(username, password, driver);
	}
	
	@When("^I add product (.+) to Cart$")
	public void add_product_to_cart(String product) {

		cartPage = homePage.addProductToCart(product, driver);
	}
	
	@And("^Checkout (.+) and Submit the order$")
	public void checkout_submit_order(String product) {

		checkoutPage = cartPage.placeOrder(product, driver);
		confPage = checkoutPage.submitOrder(driver);
	}
	
	@Then("{string} message is displayed in Confirmation page")
	public void message_displayed_confirmation_page(String string) {
		
		String confirmMessage = confPage.getConfirmation();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
}
