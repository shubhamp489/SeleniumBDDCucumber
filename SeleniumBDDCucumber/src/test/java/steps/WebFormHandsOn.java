package steps;

import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class WebFormHandsOn {
WebDriver driver;

@Given("User navigates to Home page")
public void user_navigates_to_home_page() {
    System.setProperty("webdriver.chrome.driver","Driver/chromedriver.exe");
    driver= new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://bonigarcia.dev/selenium-webdriver-java/index.html");
    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
}
@Then("User click on Web form")
public void user_click_on_web_form() {
   driver.findElement(By.xpath("//a[contains(text(),'Web form')]")).click();
}
@Then("user very Text input")
public void user_very_text_input() {
   driver.findElement(By.cssSelector("#my-text-id")).sendKeys("Shubham");
}
@Then("User enter password")
public void user_enter_password() {
   driver.findElement(By.cssSelector("input[type=password]")).sendKeys("Admin@123");
}
@Then("user enter Textarea")
public void user_enter_textarea() {
	driver.findElement(By.cssSelector("textarea[name=my-textarea]")).sendKeys("Shubham is Learning Selenium Webdriver with java");
   }


@Then("user select dropdown value")
public void user_select_dropdown_value() {
    WebElement dropDown  = driver.findElement(By.cssSelector("select[name='my-select']"));
	Select select = new Select(dropDown);
	select.selectByValue("3");
	
	
	
}
@Then("user search from dropdown datalist")
public void user_search_from_dropdown_datalist() {
    driver.findElement(By.xpath("//input[@list='my-options']")).sendKeys("New York");
    }
@Then("user click on default checkbox")
public void user_click_on_default_checkbox() {
    driver.findElement(By.cssSelector("div.form-check > label:nth-child(2)")).click();
}
@Then("user click on Default radio")
public void user_click_on_default_radio() throws Exception {
	Thread.sleep(1000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollTo(0,250)");
   
	WebElement radio2 = driver.findElement(By.xpath("//input[@id='my-radio-2']"));
	Actions actions = new Actions(driver);
    actions.moveToElement(radio2).perform();

    // Click on the element
    
	
    radio2.click();
    
}
@Then("user pick color picker")
public void user_pick_color_picker() {
    driver.findElement(By.xpath("//input[@class='form-control form-control-color']")).click();
}
@Then("user select date")
public void user_select_date() {
    driver.findElement(By.xpath("//input[@name='my-date']")).click();
    driver.findElement(By.cssSelector("body > div > div.datepicker-days > table > tbody > tr:nth-child(3) > td:nth-child(5)")).click();
    driver.findElement(By.xpath("//*[contains(text(),'Practice site')]")).click();

}
@Then("User set example range")
public void user_set_example_range() {
	WebElement slider = driver.findElement(By.name("my-range"));
    String initValue = slider.getAttribute("value");
    //log.debug("The initial value of the slider is {}", initValue);

    for (int i = 0; i < 5; i++) {
        slider.sendKeys(Keys.ARROW_RIGHT); 
    }

    String endValue = slider.getAttribute("value");
   // log.debug("The final value of the slider is {}", endValue);
   System.out.println(endValue);
}
	

@Then("User Choose FILE input")
public void user_choose_file_input() throws Exception {
	 WebElement inputFile = driver.findElement(By.name("my-file")); 

	    Path tempFile = Files.createTempFile("tempfiles", ".tmp"); 
	    String filename = tempFile.toAbsolutePath().toString();
	    //Log.debug("Using temporal file {} in file uploading", filename);
	    inputFile.sendKeys(filename); 

	    driver.findElement(By.tagName("form")).submit(); 
	    //assertThat(driver.getCurrentUrl()).isNotEqualTo(initUrl); 
}

@Then("click on submit button")
public void click_on_submit_button() {
    driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
}



	
}
