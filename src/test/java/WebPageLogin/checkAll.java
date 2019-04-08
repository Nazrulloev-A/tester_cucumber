package WebPageLogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import WebPageElements.cheackAllWebElement;
import WebPageElements.loginWebPageElements;
import io.github.bonigarcia.wdm.WebDriverManager;

public class checkAll {
	
	
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
	public void checkAll() {
		loginWebPageElements login = new loginWebPageElements(driver);
		cheackAllWebElement checkAll= new cheackAllWebElement(driver);
		login.username.sendKeys("Tester");
		login.password.sendKeys("test");
		login.loginButton.click();
		checkAll.checkAll.click();
	
	}
		
		

	
	@AfterMethod
	public void closeUp() {
		driver.close();
		driver.quit();
	}
	

}
