package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import WebPageElements.AddressWebElements;
import WebPageElements.OrderWebElement;
import WebPageElements.PaymentWebElements;
import WebPageElements.loginWebPageElements;
import WebPageElements.newOrderWebPAgeElementLink;
import WebPageElements.viewOrderWebElement;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class viewOrderStepDefinition {
	
	WebDriver driver;
	@Given("user should make order")
	public void user_should_make_order() {
		WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		  loginWebPageElements login = new loginWebPageElements(driver);
			login.username.sendKeys("Tester");
			login.password.sendKeys("test");
	   
	}

	@When("user click on process")
	public void user_click_on_process() {
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
		PaymentWebElements payment = new PaymentWebElements(driver);
		payment.visa.click();
		payment.cardnumber.sendKeys("5523123456789010");
		payment.ExDate.sendKeys("06/21");
		payment.process.click();
	}

	@Then("user should view his\\/her order")
	public void user_should_view_his_her_order() {
		viewOrderWebElement view = new viewOrderWebElement(driver);
		view.viewall.click();
		String table2 =view.table.getText();
		System.out.println(table2);
		driver.quit();
		
	}




}
