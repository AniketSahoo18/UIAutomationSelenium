package utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtils extends Parameters {

	public static WebDriverWait pageLoadWait;
	public static WebDriverWait explicitWait;

	public static void getUrl(String url, WebDriver driver) {

		try {

			driver.get(url);

		}

		catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}

	public static void getPageLoadWait(int wait, WebDriver driver) {

		pageLoadWait = new WebDriverWait(driver, Duration.ofSeconds(wait));
	}

	public static void getExplicitWait(int wait, WebDriver driver) {

		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(wait));
	}

	public static String getScreenshot(String testCaseName, WebDriver driver) throws IOException {

		TakesScreenshot ss = (TakesScreenshot) driver;
		File source = ss.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "/reports/" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "/reports/" + testCaseName + ".png";
	}
}
