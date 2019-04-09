package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import WebPageElements.AddressWebElements;
import WebPageElements.OrderWebElement;
import WebPageElements.loginWebPageElements;
import WebPageElements.newOrderWebPAgeElementLink;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class addressStepDefinition {

	WebDriver driver;
	@Given("user should be on the orders part")
	public void user_should_be_on_the_orders_part() {
		WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		  loginWebPageElements login = new loginWebPageElements(driver);
			login.username.sendKeys("Tester");
			login.password.sendKeys("test");
	   
	}

	@When("user fill the Order part")
	public void user_fill_the_Order_part() {
		loginWebPageElements login = new loginWebPageElements(driver);
		login.loginButton.click();
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
		
	}

	@Then("user should click to calculate button and see the result")
	public void user_should_click_to_calculate_button_and_see_the_result() {
		OrderWebElement order = new OrderWebElement(driver);
		order.CalculateButton.click();
	}

	@Then("user should fill the address bar in order to make payment")
	public void user_should_fill_the_address_bar_in_order_to_make_payment() {
		AddressWebElements address = new AddressWebElements(driver);
		address.Customername.sendKeys("Lenovo");
		address.street.sendKeys("4040 Royer rd Apt 30");
		address.City.sendKeys("Clivland");
		address.State.sendKeys("OH");
		address.Zip.sendKeys("123456");
		driver.close();
		driver.quit();
		
	}


}
