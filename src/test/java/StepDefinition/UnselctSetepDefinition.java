package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import WebPageElements.UncheckAllWebElement;
import WebPageElements.cheackAllWebElement;
import WebPageElements.loginWebPageElements;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UnselctSetepDefinition {
	WebDriver driver;
	
	@Given("user should login to the page")
	public void user_should_login_to_the_page() {
		WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		  loginWebPageElements login = new loginWebPageElements(driver);
			login.username.sendKeys("Tester");
			login.password.sendKeys("test");
			
	}

	@When("user should click to check all button to secelct all")
	public void user_should_click_to_check_all_button_to_secelct_all() {
		loginWebPageElements login = new loginWebPageElements(driver);
		login.loginButton.click();
		cheackAllWebElement checkAll= new cheackAllWebElement(driver);
		checkAll.checkAll.click();
	}

	@Then("user should click to unselect all button to deselct all")
	public void user_should_click_to_unselect_all_button_to_deselct_all() {
		UncheckAllWebElement uncheck = new UncheckAllWebElement(driver);
		uncheck.uncheckAll.click();
		driver.close();
		driver.quit();
	}



}
