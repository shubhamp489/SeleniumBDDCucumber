package actions;

import org.openqa.selenium.WebDriver;

import elements.EbayAdvancedSearch_Elements;
import steps.Common_Steps;

public class Ebay_Home_Page_Actions {

	private WebDriver driver;
	EbayAdvancedSearch_Elements advancedSearch_Elements;
	
	public Ebay_Home_Page_Actions(Common_Steps common_Steps) {
	this.driver = common_Steps.getDriver();
	advancedSearch_Elements =new EbayAdvancedSearch_Elements(driver);
	}
	
	public void clickonLogo() {
		advancedSearch_Elements.ebayLogo.clear();
	}
}
