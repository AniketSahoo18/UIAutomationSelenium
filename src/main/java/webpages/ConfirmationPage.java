package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {

	String confirmMessage;

	public ConfirmationPage(WebDriver driver) {

		// initialization

		PageFactory.initElements(driver, this);

	}

	// PageFactory

	@FindBy(css = ".hero-primary")
	WebElement confirmation;

	public String getConfirmation() {

		try {

			confirmMessage = confirmation.getText();

		}

		catch (Exception e) {

			System.out.println("Fail Cause: " + e.getMessage());

		}

		return confirmMessage;
	}
}
