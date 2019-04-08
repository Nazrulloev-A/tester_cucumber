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

public class invalidLoginStepDefinition {
	WebDriver driver;
	
	@Given("user should be on login page")
	public void user_should_be_on_login_page() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
	}

	@When("user type the invalid username and the valid password")
	public void user_type_the_invalid_username_and_the_valid_password() {
		loginWebPageElements login = new loginWebPageElements(driver);
		login.username.sendKeys("kelosh");
		login.username.sendKeys("test");
		login.loginButton.click();
	}

	@Then("user should see the error massage")
	public void user_should_see_the_error_massage() {
    invalidLoginWebElements invalid = new invalidLoginWebElements(driver);
		
		boolean flag =invalid.errormsg.isDisplayed();
		Assert.assertTrue(flag);
		String text = invalid.errormsg.getText();
		System.out.println(text);
		driver.close();
		driver.quit();
	}

}
