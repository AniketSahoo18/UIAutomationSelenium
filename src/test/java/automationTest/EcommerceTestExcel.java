package automationTest;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import utils.ExcelReader;
import utils.TestDataMapper;
import utils.Parameters;
import webpages.CartPage;
import webpages.CheckoutPage;
import webpages.ConfirmationPage;
import webpages.HomePage;
import webpages.LandingPage;

public class EcommerceTestExcel extends Parameters {

	LandingPage landPage;
	HomePage homePage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	ConfirmationPage confPage;

	@DataProvider(name = "testData")

	public Object[][] ecommerce() throws IOException {

		Object[][] data = ExcelReader.getTestDataMap(TestDataMapper.getEcommerce(), "Ecommerce");

		return data;
	}

	@Test(dataProvider = "testData")
	public void ecommerceTestExcel(String userName, String password, String product) {

		try {

			homePage = landPage.loginApplication(userName, password, driver);
			cartPage = homePage.addProductToCart(product, driver);
			checkoutPage = cartPage.placeOrder(product, driver);
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
