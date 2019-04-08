package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import WebPageElements.cheackAllWebElement;
import WebPageElements.deleteAllWebElement;
import WebPageElements.loginWebPageElements;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class deleteAllStepDefiniton {
	WebDriver driver;
	@Given("user should be on the login page and select all")
	public void user_should_be_on_the_login_page_and_select_all() {
		WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		  loginWebPageElements login = new loginWebPageElements(driver);
			login.username.sendKeys("Tester");
			login.password.sendKeys("test");
	}

	@When("user select check all button it should selecct all")
	public void user_select_check_all_button_it_should_selecct_all() {
		loginWebPageElements login = new loginWebPageElements(driver);
		login.loginButton.click();
		cheackAllWebElement checkAll= new cheackAllWebElement(driver);
		checkAll.checkAll.click();
	}

	@Then("user should clcik on deleteall button to delete all orders")
	public void user_should_clcik_on_deleteall_button_to_delete_all_orders() {
		deleteAllWebElement delete = new deleteAllWebElement(driver);
		delete.deleteAll.click();
		driver.close();
		driver.quit();
	}

}
