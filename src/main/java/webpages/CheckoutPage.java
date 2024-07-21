package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utils.Parameters;
import utils.TestUtils;

public class CheckoutPage extends Parameters {

	public CheckoutPage(WebDriver driver) {

		// initialization

		PageFactory.initElements(driver, this);

	}

	// PageFactory

	@FindBy(css = "[placeholder='Select Country']")
	WebElement countryField;

	@FindBy(css = ".ta-item:nth-of-type(2)")
	WebElement country;

	@FindBy(css = ".action__submit")
	WebElement placeOrder;

	public ConfirmationPage submitOrder(WebDriver driver) {

		countryField.sendKeys("India");

		TestUtils.explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

		country.click();
		placeOrder.click();

		return new ConfirmationPage(driver);
	}

}
