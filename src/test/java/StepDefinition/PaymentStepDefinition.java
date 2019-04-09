package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import WebPageElements.AddressWebElements;
import WebPageElements.OrderWebElement;
import WebPageElements.PaymentWebElements;
import WebPageElements.loginWebPageElements;
import WebPageElements.newOrderWebPAgeElementLink;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PaymentStepDefinition {
	
	WebDriver driver;
	
	@Given("user should be on the order page")
	public void user_should_be_on_the_order_page() {
		WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		  loginWebPageElements login = new loginWebPageElements(driver);
			login.username.sendKeys("Tester");
			login.password.sendKeys("test");
	}

	@When("user should fill the payment bar and select the type of card")
	public void user_should_fill_the_payment_bar_and_select_the_type_of_card() {
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
		order.CalculateButton.click();
		AddressWebElements address = new AddressWebElements(driver);
		address.Customername.sendKeys("Lenovo");
		address.street.sendKeys("4040 Royer rd Apt 30");
		address.City.sendKeys("Clivland");
		address.State.sendKeys("OH");
		address.Zip.sendKeys("123456");
	}

	@Then("user should click to Process button to make order")
	public void user_should_click_to_Process_button_to_make_order() {
		PaymentWebElements payment = new PaymentWebElements(driver);
		payment.visa.click();
		payment.cardnumber.sendKeys("5523123456789010");
		payment.ExDate.sendKeys("06/21");
		payment.process.click();
	}


}
