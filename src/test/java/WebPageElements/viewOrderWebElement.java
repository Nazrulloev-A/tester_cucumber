package WebPageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class viewOrderWebElement {
	
	public viewOrderWebElement(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(linkText="View all orders")
	public WebElement viewall;
	
	@FindBy(xpath="//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[2]")
	public WebElement table;

}
