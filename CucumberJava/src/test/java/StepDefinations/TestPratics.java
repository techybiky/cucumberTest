package StepDefinations;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestPratics {

	public static void main(String args[]) throws MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://app.endtest.io/guides/docs/how-to-test-dropdowns/");

		List<WebElement> we = null;// list of webelement
		String str = "";

		WebElement dropdown = driver.findElement(By.id("pets"));

		Select sc = new Select(dropdown);
		we = sc.getOptions();

		for (int i = 0; i <= we.size() - 1; i++) {
			str = we.get(i).getText().trim();
			System.out.println(str);
		}

		Actions as = new Actions(driver);
		as.moveToElement(dropdown).build().perform();
		driver.close();
		driver.manage().timeouts().implicitlyWait(null);
		WebDriverWait we1 = new WebDriverWait(driver, Duration.ofSeconds(1000));
		we1.until(ExpectedConditions.alertIsPresent());

		FluentWait<WebDriver> fw = new FluentWait<WebDriver>(driver);
		fw.withTimeout(Duration.ofSeconds(10));
		fw.pollingEvery(Duration.ofSeconds(1));
		fw.ignoring(NoSuchElementException.class);

		Set<String> frame = driver.getWindowHandles();

		for (String handle : frame) {
			driver.switchTo().window(handle);
			if (driver.getTitle().contains("Google")) {

				System.out.println("Switch to Google Tab");
				break;
			}

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--ignore-certificate-errors");

			WebDriver driver1 = new ChromeDriver(options);

		}
		// Https Connection Check
		HttpURLConnection connection = (HttpURLConnection) new URL(
				"https://app.endtest.io/guides/docs/how-to-test-dropdowns/").openConnection();

		int resp = connection.getResponseCode();

		System.out.println(resp);

		WebElement element = driver.findElement(By.xpath("xpath"));
		WebElement ele = driver.findElement(RelativeLocator.with(By.tagName("input")).above(element));
		ele.getText();

		driver.close();

	}

}
