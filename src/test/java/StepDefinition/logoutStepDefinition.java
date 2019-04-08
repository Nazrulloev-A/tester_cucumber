package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import WebPageElements.loginWebPageElements;
import WebPageElements.logoutWebElements;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class logoutStepDefinition {
	WebDriver driver;
	
	@Given("user should be on the login page again")
	public void user_should_be_on_the_login_page_again() {
		WebDriverManager.chromedriver().setup();
		  driver= new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
	}

	@When("user inters the valid username and valid password")
	public void user_inters_the_valid_username_and_valid_password() {
		loginWebPageElements login = new loginWebPageElements(driver);
		login.username.sendKeys("Tester");
		login.password.sendKeys("test");
	}

	@Then("user should click on login button")
	public void user_should_click_on_login_button() {
		loginWebPageElements login = new loginWebPageElements(driver);
		login.loginButton.click();
		
	}

	@Then("user should click on log out button to log out")
	public void user_should_click_on_log_out_button_to_log_out() {
		logoutWebElements out = new logoutWebElements(driver);
		out.logout.click();
		driver.close();
		driver.quit();
	}

}
