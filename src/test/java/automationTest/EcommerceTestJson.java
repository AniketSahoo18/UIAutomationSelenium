package automationTest;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import utils.JsonReader;
import utils.Parameters;
import webpages.CartPage;
import webpages.CheckoutPage;
import webpages.ConfirmationPage;
import webpages.HomePage;
import webpages.LandingPage;

public class EcommerceTestJson extends Parameters {

	LandingPage landPage;
	HomePage homePage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	ConfirmationPage confPage;

	@DataProvider(name = "testData")

	public Object[][] ecommerce() throws IOException {

		List<HashMap<String, String>> data = JsonReader.getJsonToMap(
				"D:\\Automation\\UI\\UISeleniumFramework\\src\\test\\resources\\InputData\\purchaseOrder.json");

		return new Object[][] { { data.get(0) }, { data.get(1) } };

	}

	@Test(dataProvider = "testData")
	public void ecommerceTestJson(HashMap<String, String> mapData) {

		try {

			homePage = landPage.loginApplication(mapData.get("UserName"), mapData.get("Password"), driver);
			cartPage = homePage.addProductToCart(mapData.get("Product"), driver);
			checkoutPage = cartPage.placeOrder(mapData.get("Product"), driver);
			confPage = checkoutPage.submitOrder(driver);
			String confirmMessage = confPage.getConfirmation();
			Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

		}

		catch (Exception e) {

			e.printStackTrace();
		}
	}

	@BeforeMethod(alwaysRun = true)

	public void testPreReq() {

		propLoad();
		setUp();

		landPage = new LandingPage(driver);

		landPage.launchApp(driver);

	}

	@AfterMethod(alwaysRun = true)

	public void tearDown() {

		driver.quit();
	}
}
