package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import WebPageElements.loginWebPageElements;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class loginStepDefinition {

	WebDriver driver;

@Given("User should be on login page")
public void user_should_be_on_login_page() {
  WebDriverManager.chromedriver().setup();
  driver= new ChromeDriver();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  driver.manage().window().maximize();
  driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
  
}

@When("user enters the username and password")
public void user_enters_the_username_and_password() {
	loginWebPageElements login = new loginWebPageElements(driver);
	login.username.sendKeys("Tester");
	login.password.sendKeys("test");
}

@Then("user should click button and login succesful")
public void user_should_click_button_and_login_succesful() {
	loginWebPageElements login = new loginWebPageElements(driver);
	login.loginButton.click();
	driver.close();
	driver.quit();
}


}
