package webpages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.Parameters;

public class CartPage extends Parameters {

	public CartPage(WebDriver driver) {

		// initialization

		PageFactory.initElements(driver, this);

	}

	// PageFactory

	@FindBy(css = ".cartSection h3")
	List<WebElement> cartProducts;

	@FindBy(css = ".totalRow button")
	WebElement checkout;

	public CheckoutPage placeOrder(String productName, WebDriver driver) {

		try {

			// Checking product is added in Cart

			Boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equals(productName));

			Assert.assertTrue(match);

			// Checkout

			checkout.click();

		}

		catch (Exception e) {

			System.out.println("Fail Cause: " + e.getMessage());

		}

		return new CheckoutPage(driver);
	}
}
