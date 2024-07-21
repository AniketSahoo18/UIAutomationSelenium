package webpages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utils.Parameters;
import utils.TestUtils;

public class HomePage extends Parameters {

	public HomePage(WebDriver driver) {

		// initialization

		PageFactory.initElements(driver, this);
	}

	// PageFactory

	@FindBy(css = ".mb-3")
	List<WebElement> products;

	@FindBy(css = ".ng-animating")
	WebElement ngAnimation;

	@FindBy(css = "[routerlink*='cart']")
	WebElement cart;

	public CartPage addProductToCart(String productName, WebDriver driver) {

		try {

			TestUtils.explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

			WebElement prod = products.stream()
					.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName))
					.findFirst().orElse(null);

			prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

			TestUtils.explicitWait
					.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));

			// ng-animating
			TestUtils.explicitWait.until(ExpectedConditions.invisibilityOf(ngAnimation));

			// Click Cart
			cart.click();

		}

		catch (Exception e) {

			System.out.println("Fail Cause: " + e.getMessage());

		}

		return new CartPage(driver);
	}
}
