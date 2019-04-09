package WebPageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressWebElements {
	
	public AddressWebElements (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="ctl00_MainContent_fmwOrder_txtName")
	public WebElement Customername;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox2")
	public WebElement street;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox3")
	public WebElement City;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox4")
	public WebElement State;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox5")
	public WebElement Zip;
	
	
	
}
