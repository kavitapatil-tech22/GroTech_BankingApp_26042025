package Utilities;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	
	
	static String browserName;
	public static WebDriver driver;
	
	public static WebDriver initializeDriver() 
	{
		
		try {
			browserName=FetchDataFromProperty.readDataFromProperty().getProperty("browser");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			
			driver=new ChromeDriver();
			try {
				driver.get(FetchDataFromExcel.getURL());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			driver.manage().window().maximize();
		}
		
		if(browserName.equalsIgnoreCase("firefox"))
		{
			
			driver=new FirefoxDriver();
			try {
				driver.get(FetchDataFromExcel.getURL());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			driver.manage().window().maximize();
		}
		
		if(browserName.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
			try {
				driver.get(FetchDataFromExcel.getURL());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			driver.manage().window().maximize();
		}
		
		return driver;
		
	}
	
	public static void addImplicitWait()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public static void scrollDown()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}
	
	public static String getPageTitle()
	{
	   String title=driver.getTitle();
	   return title;
	}
	
	
	public void addHardcodedWait() throws InterruptedException
	{
		Thread.sleep(3000);
	}
	

	
	
	
	
	

}
