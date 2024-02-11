package steps;

import static org.testng.Assert.fail;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EbayHome_steps {
	WebDriver driver;

	public EbayHome_steps(Common_Steps Common_Steps) {
		this.driver = Common_Steps.getDriver();
	}

	@Given("I am on Ebay Home Page")
	public void i_am_on_ebay_home_page() {

		driver.get("https://www.ebay.com/");

	}

	@When("I click on Advanced Link")
	public void i_click_on_advanced_link() {
		driver.findElement(By.linkText("Advanced")).click();
	}

	@Then("I Navigate to Advanced Search Page")
	public void i_navigate_to_advanced_search_page() {

		String actUrl = driver.getCurrentUrl();
		System.out.println(actUrl);
	}

	@When("I search for {string} in {string}' category")
	public void i_search_for_in_category(String string, String string2) throws Exception {
		driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys(string);
		List<WebElement> cat = driver.findElements(By.xpath("//select[@id='gh-cat']/option"));
		for (WebElement x : cat) {
			if (x.getText().trim().equals(string2)) {
				x.click();
				break;
			}
		}
		driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
		Thread.sleep(1000);
	}

	@Then("I click on {string}")
	public void i_click_on(String string) throws Exception {
		driver.findElement(By.linkText(string)).click();
		Thread.sleep(2000);
	}

	@Then("I validate that page navigates to {string} and title contains {string}")
	public void i_validate_that_page_navigates_to_and_title_contains(String url, String title) {
		String actualurl=driver.getCurrentUrl();
		String actTitle = driver.getTitle();
		if(!actualurl.equals(url)) {
			fail("Page does not navigate to expected url :"+url);
		}
		if(!actTitle.contains(title)) {
			fail("Title mismatch");
		}
	}

}
