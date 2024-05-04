package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbayAdvancedSearch_Elements {

	WebDriver driver;
	@FindBy(xpath="") public WebElement ebayLogo;
	
//	
//	public EbayAdvancedSearch_Elements(WebDriver driver) {
//		this.driver = driver;
//		PageFactory.initElements(driver,this);
//	}
	
	
	public EbayAdvancedSearch_Elements(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
}
