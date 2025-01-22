package StepDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {

	protected static WebDriver driver;

	public static WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		if (driver == null) {
	        ChromeOptions options = new ChromeOptions();
	        if (Boolean.parseBoolean(System.getProperty("headless", "true"))) {
	            options.addArguments("--headless");
	        }
	        options.addArguments("--disable-gpu");
	        options.addArguments("--window-size=1920,1080");

	        driver = new ChromeDriver(options);
		}
		return driver;
	}

	public static void closeDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
