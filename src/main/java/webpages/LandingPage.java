package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utils.Parameters;
import utils.TestUtils;

public class LandingPage extends Parameters {

	public LandingPage(WebDriver driver) {

		// initialization

		PageFactory.initElements(driver, this);
	}

	// PageFactory

	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement userPassword;

	@FindBy(id = "login")
	WebElement submit;

	@FindBy(css = "[class*='flyInOut']")
	WebElement errorMessage;

	public void launchApp(WebDriver driver) {

		try {

			TestUtils.getUrl(url, driver);
			TestUtils.getPageLoadWait(pageLoadWait, driver);
			TestUtils.getExplicitWait(driverExplicitWait, driver);

		}

		catch (Exception e) {

			System.out.println("Fail Cause: " + e.getMessage());

		}

	}

	public HomePage loginApplication(String email, String password, WebDriver driver) {

		try {

			userEmail.sendKeys(email);
			userPassword.sendKeys(password);
			submit.click();

		}

		catch (Exception e) {

			System.out.println("Fail Cause: " + e.getMessage());

		}
		return new HomePage(driver);
	}

}
