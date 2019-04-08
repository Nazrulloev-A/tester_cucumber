package WebPageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UncheckAllWebElement {
	public UncheckAllWebElement (WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="ctl00_MainContent_btnUncheckAll")
	public WebElement uncheckAll;

}
