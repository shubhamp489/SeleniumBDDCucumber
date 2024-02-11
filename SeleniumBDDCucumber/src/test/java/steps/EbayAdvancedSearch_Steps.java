package steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class EbayAdvancedSearch_Steps {
	WebDriver driver;
	public EbayAdvancedSearch_Steps(Common_Steps Common_Steps) {
		this.driver=Common_Steps.getDriver();
	}

	@Given("I am Ebay Advanced Search Page")
	public void i_am_ebay_advanced_search_page() {
		
		driver.get("https://www.ebay.com/");
	}

	@When("I Enter Search anything")
	public void i_enter_search_anything() {
		driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("Book");
	}

	@Then("I click on search button")
	public void i_click_on_search_button() {
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		List <WebElement> l1= driver.findElements(By.cssSelector("#srp-river-results > ul > li"));
		System.out.println(l1);
	}
}
