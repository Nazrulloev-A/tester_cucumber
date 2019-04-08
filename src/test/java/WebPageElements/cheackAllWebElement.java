package WebPageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cheackAllWebElement {
	
	public cheackAllWebElement(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(id="ctl00_MainContent_btnCheckAll")
	public WebElement checkAll;

}
