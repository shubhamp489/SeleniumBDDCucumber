package steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;

public class Boigarcia {
	WebDriver driver;

	public Boigarcia(BaseClass BaseClass) {
		this.driver = BaseClass.getDriver();
	}

	@Given("User open bonigarcia home page")
	public void user_open_bonigarcia_home_page() {
		System.out.println("User is on Bonigarica");
	}

	@Then("User verify url")
	public void user_verify_url() {
		String url = driver.getTitle();
		System.out.println(url);
	}

}
