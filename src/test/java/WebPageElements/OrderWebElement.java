package WebPageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderWebElement {
	
	public OrderWebElement(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//*[@id=\"ctl00_MainContent_fmwOrder_ddlProduct\"]/option[1]")
	public WebElement Money;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_txtQuantity")
	public WebElement Quantity;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_txtUnitPrice")
	public WebElement PriceperUnit;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_txtDiscount")
	public WebElement Discount;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_txtTotal")
	public WebElement total;
	
	@FindBy(xpath="//input[@value='Calculate']")
	public WebElement CalculateButton;

}
