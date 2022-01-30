package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;



public class Login {
	
	WebDriver driver;
    WebDriverWait wait;
	public Login(WebDriver driver)
	{
		this.driver=driver;
		wait=new WebDriverWait(driver, 20);
	}
	private static By userName=By.id("email");
	private static By passWord=By.id("password");
	private static By login=By.id("logIn");
	
		public  void navigateURL() {
		driver.navigate().to("https://www.hudl.com/home");
		driver.manage().window().maximize();
	}
	
		 public  void pageLoad(By Element) {
		    	wait.until(ExpectedConditions.visibilityOfElementLocated(Element));
			}
	public void enterCreds(String username,String password) {
		pageLoad(userName);
		driver.findElement(userName).sendKeys(username);
		driver.findElement(passWord).sendKeys(password);
		driver.findElement(login).click();

		System.out.println("User logged in successfully");
	}
	
	
	
	
}
