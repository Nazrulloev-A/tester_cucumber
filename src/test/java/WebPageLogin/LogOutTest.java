package WebPageLogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import WebPageElements.loginWebPageElements;
import WebPageElements.logoutWebElements;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LogOutTest {
	
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
	public void login() {
		loginWebPageElements login = new loginWebPageElements(driver);
		login.username.sendKeys("Tester");
		login.username.sendKeys("test");
		login.loginButton.click();
		logoutWebElements out = new logoutWebElements(driver);
		out.logout.click();
	}

	
	@AfterMethod
	public void closeUp() {
		driver.close();
		driver.quit();
	}
	
}
