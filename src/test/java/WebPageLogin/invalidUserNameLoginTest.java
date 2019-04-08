package WebPageLogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import WebPageElements.invalidLoginWebElements;
import WebPageElements.loginWebPageElements;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class invalidUserNameLoginTest {
	
	
WebDriver driver;
	
	
	@BeforeMethod
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
	}
	
	
	@Test
	public void invalidUserNameLogin() {
		loginWebPageElements login = new loginWebPageElements(driver);
		login.username.sendKeys("kelosh");
		login.username.sendKeys("test");
		login.loginButton.click();
		
		invalidLoginWebElements invalid = new invalidLoginWebElements(driver);
		
		boolean flag =invalid.errormsg.isDisplayed();
		Assert.assertTrue(flag);
	}

	
	@AfterMethod
	public void closeUp() {
		driver.close();
		driver.quit();
	}
	

}
