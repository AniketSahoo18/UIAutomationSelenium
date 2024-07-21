package utils;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Parameters {

	public static String browser;
	public static String url;
	public static String inputPath;
//	public static String jsonPath;
	public static int driverStartupWait;
	public static int pageLoadWait;
	public static int frameLoadWait;
	public static int driverExplicitWait;
	public static Properties prop;

	public WebDriver driver;

	public static void propLoad() {

		try {

			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"D:\\Automation\\UI\\UISeleniumFramework\\src\\main\\resources\\config.properties");
			prop.load(ip);

			browser = prop.getProperty("browser");
			url = prop.getProperty("url");
			inputPath = prop.getProperty("inputPath");
//			jsonPath = prop.getProperty("jsonPath");
			driverStartupWait = Integer.parseInt(prop.getProperty("driverStartupWait"));
			pageLoadWait = Integer.parseInt(prop.getProperty("pageLoadWait"));
			frameLoadWait = Integer.parseInt(prop.getProperty("frameLoadWait"));
			driverExplicitWait = Integer.parseInt(prop.getProperty("driverExplicitWait"));

//			ip.close();

		}

		catch (Exception e) {

			Assert.fail(e.getMessage());
		}

	}

	public void setUp() {

		driver = BrowserFactory.createBrowserInstance(browser, driverStartupWait);
		
	}
}
