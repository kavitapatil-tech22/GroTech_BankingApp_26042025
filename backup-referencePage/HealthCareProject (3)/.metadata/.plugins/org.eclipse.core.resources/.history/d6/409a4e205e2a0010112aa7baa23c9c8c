package testClasses;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



import pageClasses.LoginPage;
import pageClasses.RegisterPage;
import utilities.BaseClass;
import utilities.ListenerImplementation;


@Listeners(ListenerImplementation.class)
public class LoginTest extends BaseClass{

//	LoginPage login=new  LoginPage();
	
	@Test(priority = 0, groups = {"sanity"},retryAnalyzer = utilities.RetryAnalyzer.class)
	 
	public static void executeLoginTest() throws InterruptedException
	{
		
		addExplicitWait(LoginPage.getUserName());
		driver.findElement(LoginPage.getUserName()).sendKeys("Admin");
		addExplicitWait(LoginPage.getContinueButton());
		driver.findElement(LoginPage.getContinueButton()).click();
		addExplicitWait(LoginPage.getPassword());
		driver.findElement(LoginPage.getPassword()).sendKeys("Admin123");
		addExplicitWait(LoginPage.clickOnSumit());
		driver.findElement(LoginPage.clickOnSumit()).click();
		
		
	}
	
	
	
	
	

}
