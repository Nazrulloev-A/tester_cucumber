package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import WebPageElements.cheackAllWebElement;
import WebPageElements.loginWebPageElements;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class checkAllStepSefinition {
	
	WebDriver driver;
	@Given("user should login to the webpage with the valid credentials")
	public void user_should_login_to_the_webpage_with_the_valid_credentials() {
		WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		  loginWebPageElements login = new loginWebPageElements(driver);
			login.username.sendKeys("Tester");
			login.password.sendKeys("test");
	}

	@When("user should click th login button")
	public void user_should_click_th_login_button() {
		loginWebPageElements login = new loginWebPageElements(driver);
		login.loginButton.click();
	}

	@Then("user should click to  checkall button")
	public void user_should_click_to_checkall_button() {
		cheackAllWebElement checkAll= new cheackAllWebElement(driver);
		checkAll.checkAll.click();
		driver.close();
		driver.quit();
	}

}
