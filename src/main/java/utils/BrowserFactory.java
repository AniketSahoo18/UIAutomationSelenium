package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory extends Parameters {

	public static WebDriver createBrowserInstance(String browser, int wait) {

		WebDriver driver = null;

		try {
			if (browser.equalsIgnoreCase("chrome")) {

				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--incognito");
				options.addArguments("disable-popup-blocking");
				driver = new ChromeDriver(options);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
				driver.manage().window().maximize();
			}

			else if (browser.equalsIgnoreCase("edge")) {

				WebDriverManager.edgedriver().setup();
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--incognito");
				options.addArguments("disable-popup-blocking");
				driver = new EdgeDriver(options);
				driver.manage().window().maximize();
			}

			else if (browser.equalsIgnoreCase("firefox")) {

				// NEED TO IMPLEMENT
			}

			else {

				System.out.println("Browser Option Entered is Wrong");
			}
		}

		catch (Exception e) {

			e.printStackTrace();
		}

		return driver;
	}
}
