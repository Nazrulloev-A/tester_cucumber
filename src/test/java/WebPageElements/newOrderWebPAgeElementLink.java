package WebPageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class newOrderWebPAgeElementLink {

	public newOrderWebPAgeElementLink (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="Order")
	public WebElement orderTab;
}
