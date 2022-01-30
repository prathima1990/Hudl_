package sage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import pages.Login;
import pages.HomePage;

public class Functional{

	private Login login;
	private HomePage homePage;
	WebDriver driver;
	@BeforeMethod
	public void openDriver()
	{
		 System.setProperty("webdriver.chrome.driver","/Users/sumaakondi/eclipse-workspace/Hudl/src/main/resources/chromedriver");   
		 driver= new ChromeDriver();
		 
		 }
	
  @Test
  public void sageObjective() {
	 
		
	  login=new Login(driver);
	  homePage=new HomePage(driver);
	

	 login.navigateURL();
	 login.enterCreds("purnaprathima11@gmail.com", "Water786!");

	  
	  login=new Login(driver);
	  homePage=new HomePage(driver);
	  homePage.homeFeed();
	  homePage.video();
	 }
  @AfterTest
	 
	  public void quit() {
	  
//driver.quit();
  }
  
	
  
}
