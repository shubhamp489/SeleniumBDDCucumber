package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseClass {
private WebDriver driver;
	
	//@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","Driver/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/index.html");
	}
	
	
	//@After
	public void tearDown()throws Exception{
		driver.quit();
		Thread.sleep(1000);
		
	}
	
	public WebDriver getDriver() {
		return driver;
	}
}
