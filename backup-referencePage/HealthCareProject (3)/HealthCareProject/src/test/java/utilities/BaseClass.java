package utilities;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

   /*declare WebDriver */
	
	public static WebDriver driver;
	
	@BeforeMethod(alwaysRun = true)
	public void openBrowser() throws IOException
	{
		String browserName=FetchDataFromProperty.readDataFromProperty().getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver =new ChromeDriver();
			driver.get(FetchDataFromProperty.readDataFromProperty().getProperty("URL"));
			driver.manage().window().maximize();
			addImpicitWait();		
		}		
		if(browserName.equalsIgnoreCase("edge"))
		{
			driver =new EdgeDriver();
			driver.get(FetchDataFromProperty.readDataFromProperty().getProperty("URL"));
			driver.manage().window().maximize();
			addImpicitWait();
		}
		if(browserName.equalsIgnoreCase("firefox"))
		{
			driver =new FirefoxDriver();
			driver.get(FetchDataFromProperty.readDataFromProperty().getProperty("URL"));
			driver.manage().window().maximize();
			addImpicitWait();
		}
		else {
			if (driver == null) {
			    System.out.println("ERROR: WebDriver is null!");
			    return;
			}
		}		
	}
	
	public static void addExplicitWait(By string) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(string));	    
	    
	}
	public static void addExplicitWait1(By locator) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));	    
	    
	}
	public static void addExplicitWait2(WebElement locator) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	    wait.until(ExpectedConditions.visibilityOf(locator));	    
	    
	}
	public static void addExplicitWait3(By locator) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	public static List<WebElement> addExplicitWaitForAllElementsLocated(By locator) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	    return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));	    
	    
	}
	public static void addExplicitWait_presenceOfElementLocated(By locator) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		WebElement calendarButton = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		   
		
		wait.until(ExpectedConditions.elementToBeClickable(calendarButton));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", calendarButton);
		
	}
	
	public static void scrollDownDivTag() {
		/* Locate the div tag */
		WebElement div = driver.findElement(By.xpath("//div[contains(@class, 'gs9YbjxTsA4FpyAla1+69g==')]"));
		// Use JavaScript to scroll the div tag
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollTo(0, 700);", div);
	}
	public static void addExplicitWait_elementclickable(By locator) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));
	    
	    // Scroll into view to avoid click interception
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(2000); // Allow scroll to settle
	}
	
	
	
	public static void addImpicitWait() {
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public static void scrollDown()
	{
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", " ");
	}
		
	//if the page doent have <footer> tag  then use this below method	
	public static void scrollToBottom(WebDriver driver) {
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		    
	}
	//if the page doent have <header> tag  then use this below method	
	public static void scrollToTop(WebDriver driver) {
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollTo(0, 0);"); // Scroll to top left corner
	}
	public static void scrollToTop1(WebDriver driver)
	{
	WebElement topElement = driver.findElement(By.cssSelector(".top-nav"));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", topElement);
	}
	public static void scrollToTableHeader(WebDriver driver) {
	    WebElement tableHeader = driver.findElement(By.cssSelector("table thead th")); // or a more specific selector
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tableHeader);
	}
	public static void scrollToSpecificHeader(WebDriver driver) {
	    WebElement specificHeader = driver.findElement(By.cssSelector("table thead th:nth-child(3)"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", specificHeader);
	}
	/* The JavaScript click often helps when normal .click() fails due to hidden elements, overlays, or UI transitions. */
	public static void jsClick(WebDriver driver, WebElement element) {
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}	
	
	@AfterTest(alwaysRun = true)
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
		
	}
	

}
	
	
	
	
	
	
	
	
	
	

