package StepDefinations;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class dealsStep {

	WebDriver driver;

	@Given("^User is already login page$")
	public void user_is_already_login_page() {

		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.freecrm.com/");
		driver.manage().window().maximize();

	}

	@When("^Title of login page is Login CRM$")
	public void verify_page_titie() {

		String title = driver.getTitle();
		String actualTitle = "#1 Free CRM Power Up your Entire Business Free Forever";
		Assert.assertEquals(actualTitle, title);

	}

	@Then("^User enter username and User enter password$")
	public void user_enter_username_and_user_enrer_password(DataTable credentails) {
		List<List<String>> data = credentails.asLists();
		driver.findElement(By.xpath("/html/body/div[1]/header/div/nav/div[2]/div/div[2]/ul/a")).click();
		driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[1]/div/input")).sendKeys(data.get(0).get(0));
		driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[2]/div/input")).sendKeys(data.get(0).get(1));

	}

	@Then("^User click on Login button$")
	public void user_click_login() {
		driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[3]")).click();

	}

	@Then("^User is on Homepage$")
	public void user_on_homepage() throws Throwable {
		String homepagetitile = driver.getTitle();
		Assert.assertEquals("Cogmento CRM", homepagetitile);
		Thread.sleep(2000);
	}

	@Then("^User move to deal page and create a new deals$")
	public void user_click_on_add_contact_and_enter_and(DataTable creidentails) throws Throwable {
		List<List<String>> data = creidentails.asLists();
		WebElement hoverable = driver.findElement(By.xpath("//span[text()='Deals']/parent::a"));
		new Actions(driver).moveToElement(hoverable).click().perform();
		driver.findElement(By.xpath("//button[text()='Create']")).click();
		driver.findElement(By.name("title")).sendKeys(data.get(0).get(0));
		driver.findElement(By.name("probability")).sendKeys(data.get(0).get(1));
		driver.findElement(By.name("amount")).sendKeys(data.get(0).get(2));
		driver.findElement(By.name("commission")).sendKeys(data.get(0).get(3));
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		Thread.sleep(2000);
	}

	@Then("^Close the browser$")
	public void close_browser() {
		driver.quit();
	}
}
