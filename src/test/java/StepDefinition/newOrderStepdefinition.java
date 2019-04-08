package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import WebPageElements.UncheckAllWebElement;
import WebPageElements.cheackAllWebElement;
import WebPageElements.loginWebPageElements;
import WebPageElements.newOrderWebPAgeElementLink;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class newOrderStepdefinition {

	WebDriver driver;
	
	@Given("user should login to the order pages")
	public void user_should_login_to_the_order_pages() {
		WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		  loginWebPageElements login = new loginWebPageElements(driver);
			login.username.sendKeys("Tester");
			login.password.sendKeys("test");
	}

	@When("user should clickall oerdrs and select all")
	public void user_should_clickall_oerdrs_and_select_all() {
		loginWebPageElements login = new loginWebPageElements(driver);
		login.loginButton.click();
		cheackAllWebElement checkAll= new cheackAllWebElement(driver);
		checkAll.checkAll.click();
		
	}

	@Then("user should dellete all oedres and make the new one")
	public void user_should_dellete_all_oedres_and_make_the_new_one() {
		UncheckAllWebElement uncheck = new UncheckAllWebElement(driver);
		uncheck.uncheckAll.click();
		newOrderWebPAgeElementLink clickorder = new newOrderWebPAgeElementLink(driver);
		clickorder.orderTab.click();
	String order=clickorder.orderTab.getText();
		System.out.println(order);
		driver.close();
		driver.quit();
	}

}
