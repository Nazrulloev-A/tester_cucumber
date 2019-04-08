package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import WebPageElements.invalidLoginWebElements;
import WebPageElements.loginWebPageElements;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class invalidPasswordLogin {
	
	WebDriver driver;
	@Given("user should be on the login page")
	public void user_should_be_on_the_login_page() {
		WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
	  
	}

	@When("user type the valid Username and invalid password")
	public void user_type_the_valid_Username_and_invalid_password() {
		loginWebPageElements login = new loginWebPageElements(driver);
		login.username.sendKeys("Tester");
		login.username.sendKeys("uster");
		login.loginButton.click();
	}

	@Then("user should see the error message")
	public void user_should_see_the_error_message() {
		 invalidLoginWebElements invalid = new invalidLoginWebElements(driver);
			
			boolean flag =invalid.errormsg.isDisplayed();
			Assert.assertTrue(flag);
			String text = invalid.errormsg.getText();
			System.out.println(text);
			driver.close();
			driver.quit();
	}


}
