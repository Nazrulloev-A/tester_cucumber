package WebPageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentWebElements {
	
	public PaymentWebElements(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="ctl00_MainContent_fmwOrder_cardList_0")
	public WebElement visa;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox6")
	public WebElement cardnumber;

	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox1")
	public WebElement ExDate;

	
	@FindBy(xpath="//a[@id='ctl00_MainContent_fmwOrder_InsertButton']")
	public WebElement process;


}
