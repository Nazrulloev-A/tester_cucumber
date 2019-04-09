package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import WebPageElements.OrderWebElement;
import WebPageElements.loginWebPageElements;
import WebPageElements.newOrderWebPAgeElementLink;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class orderStepDefinition {
	
	WebDriver driver;
	
	@Given("user should be login to orderpage")
	public void user_should_be_login_to_orderpage() {
		WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		  loginWebPageElements login = new loginWebPageElements(driver);
			login.username.sendKeys("Tester");
			login.password.sendKeys("test");
	}

	@When("user should make new orders and calculate it")
	public void user_should_make_new_orders_and_calculate_it() {
		loginWebPageElements login = new loginWebPageElements(driver);
		login.loginButton.click();
	}

	@Then("user should click to calculate button then see the result of order")
	public void user_should_click_to_calculate_button_then_see_the_result_of_order() {
		newOrderWebPAgeElementLink clickorder = new newOrderWebPAgeElementLink(driver);
		clickorder.orderTab.click();
		OrderWebElement order = new OrderWebElement(driver);
		order.Money.click();
		order.Quantity.clear();
		order.Quantity.sendKeys("1200");
		order.PriceperUnit.clear();
		order.PriceperUnit.sendKeys("80");
		order.Discount.clear();
		order.Discount.sendKeys("3");
	    order.total.isDisplayed();
		order.CalculateButton.click();
		driver.close();
	}

}
