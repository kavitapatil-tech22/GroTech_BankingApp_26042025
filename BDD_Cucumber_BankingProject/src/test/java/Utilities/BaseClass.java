package Utilities;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseClass {
		
	static String browserName;
	public static WebDriver driver;	
	public static WebDriver initializeDriver() 
	{		
		try {
			browserName=FetchDataFromProperty.readDataFromProperty().getProperty("browser");
		} catch (IOException e) {			
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
		Thread.sleep(20000);
	}

	
	// For WebElement (e.g., @FindBy)
	public WebElement waitForElementVisible(WebElement element, int timeoutInSeconds) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	    return wait.until(ExpectedConditions.visibilityOf(element));
	}

	// For By locators
	public WebElement waitForElementVisible(By locator, int timeoutInSeconds) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// For clickable WebElement
	public WebElement waitForElementClickable(WebElement element, int timeoutInSeconds) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	    return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	
	public static void addExplicitWait(By locator) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static String addValidateMessage(By locator) {
		String text = driver.findElement(locator).getText();
		return text;
	}


	public static void switchToChildWindow(WebDriver driver) {
	    // Get all window handles
	    Set<String> windowHandles = driver.getWindowHandles();
	    Iterator<String> iterator = windowHandles.iterator();

	    String parentWindow = iterator.next();
	    String childWindow = iterator.next();  

	    // Switch to child window
	    driver.switchTo().window(childWindow);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
