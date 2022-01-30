package pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;


public class HomePage {
	
	WebDriver driver;
    WebDriverWait wait;
    public  JavascriptExecutor js ;


	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		wait=new WebDriverWait(driver, 20);
		this.js= (JavascriptExecutor) driver;
	}
	
	private static By tab(String tabValue) {
		return By.xpath("//span[text()='"+tabValue+"']");
		 //video feed trending featured yourteams newtest , years
	}
	
	private static By search=By.xpath("//input[@title='Search']");
	
	private static By fields=By.xpath("//div[@class='search-results']/a[1]");
	
	private static By name=By.xpath("//h2[@class='uni-headline--1']");
	
	private static By home=By.xpath("//span[text()='Home']");
	
	private static By video=By.xpath("//span[text()='Video']");
	private static By categories=By.xpath("//li[@value='newtest']");
	
	private static By year(int value) {
		//return By.xpath("//span[text()='"+value+"']/ancestor::span/preceding-sibling::div");
		return By.xpath("//span[text()='Events']/parent::div/following-sibling::div["+value+"]//label");
	
	
	}
	
	private static By month=By.xpath("//div[@class='video-group'][1]/div[1]/h2");
	
	private static By yearText(int value) {
	return By.xpath("//span[text()='Events']/parent::div/following-sibling::div["+value+"]//li/span/div/span");
	}
	private static By videoYear=By.xpath("//div[@class='video-group'][1]/div[2]/a/div[2]/div/div/div/p/span");
	
	private static By videoExit=By.xpath("//span[text()='Exit']");
	
	
    public  void pageLoad(By Element) {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(Element));
	}
   
    public void homeFeed() {
    	pageLoad(tab("Trending"));
    	System.out.println(driver.getTitle()+" is the title");
    	driver.findElement(tab("Trending")).click();
    	//js.executeScript("window.scrollBy(0, 250)");
    	
    	((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	System.out.println("Verified Trending tab");
    	driver.findElement(tab("Featured")).click();
    	js.executeScript("window.scrollBy(0, 250)");
    	System.out.println("Verified Featured tab");
    	driver.findElement(tab("Your Teams")).click();
    	js.executeScript("window.scrollBy(0, 300)");
    	System.out.println("Verified Your Teams tab");

    
        driver.findElement(search).sendKeys("Leeds");
        new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(fields));
        driver.findElement(fields).click();
        System.out.println("Name of the profile is "+driver.findElement(name).getText());
        driver.findElement(home).click();
      
          
        
    }
    
    public void video() {
    	
    	
    	  driver.findElement(video).click();
          
          WebElement element = driver.findElement(By.xpath("//span[text()='Events']"));
          js.executeScript("arguments[0].scrollIntoView(true);",element);
          
          for(int i=1;i<=6;i++) {
          
          driver.findElement(year(i)).click();
          
          try {
      		Thread.sleep(5000);
      	} catch (InterruptedException e) {
      		// TODO Auto-generated catch block
      		e.printStackTrace();
      	}
              
          
          String getMonth=driver.findElement(month).getText();
          String getYears=driver.findElement(yearText(i)).getText();
          
          String[] years=getYears.split("-", 2);
          System.out.println("Expected Years "+years[0]+" "+years[1]);
         
          String[] yM=getMonth.split(" ", 2);
          System.out.println("Actual year "+yM[0]+" "+yM[1]);
          
         // assertTrue(yM[1].equals(years[0]) || yM[1].equals(years[1]));

  		
  		 if(yM[1].equals(years[0]) || yM[1].equals(years[1])){
  		  
  		  System.out.println("Year in Range"); } else {
  		  System.out.println("Year not in Range"); }
  		 
          
          driver.findElement(year(i)).click();
          }
    }
    
	}
