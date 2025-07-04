package PageClasses;

import java.time.Duration;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='/login']")
	WebElement btn_loginLink;
	
	//@FindBy(xpath="//input[@id='input_1495646567135']")
	@FindBy(xpath="(//input[@class='t-input js-tilda-rule t-input_pvis'])[1]")
	WebElement userName;
	
	@FindBy(xpath="//input[@id='input_1742715919526']")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement btn_submitLogin;
	
	@FindBy(xpath="//div[@class='js-successbox t-form__successbox t-text t-text_md']")
	WebElement val_textMessage;
	
	//@FindBy(xpath="//title[text()='Log In']")
	//WebElement val_titleofPage;
	
	
	public void clickOnLogin()
	{
		btn_loginLink.click();
	}
	
	public void enterUserName(String userid) {
		userName.sendKeys(userid);
	}
	public void enterPassword(String Password) {
		password.sendKeys(Password);
	}	
	public void clickonSubmit()
	{
		btn_submitLogin.submit();
	}	
	public String validate_txtMessage() {
		//String txt_Message=val_textMessage.getText();
		//return txt_Message;
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement messageElement = wait.until(ExpectedConditions.visibilityOf(val_textMessage)); // <-- update locator
		String actualMessage = messageElement.getText();
		
		return actualMessage;
	}

	public String validateTitleOfThePage()
	{
		//String message=val_titleofPage.getText();
		String title =driver.getTitle();
		return title;
	}


	public String ValTitle() {
		
		String actualTitle = driver.getTitle();
		return actualTitle;
		

	}
	
	public void val_expectedConditionWaitForLoginButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

	    // CSS selector matching the element that contains the success message
	    By successMsgLocator = By.cssSelector("div.js-successbox.t-form__successbox");

	    // Wait until the success message appears and contains expected text
	    wait.until(ExpectedConditions.textToBePresentInElementLocated(
	        successMsgLocator, "Thank you!"
	    ));

	    WebElement successMsgElement = driver.findElement(successMsgLocator);
	    String actualMessage = successMsgElement.getText();

	    System.out.println("Actual message: " + actualMessage);

	    // Assertion
	    Assert.assertEquals(actualMessage.trim(), "Thank you! Your data has been submitted.");
		
	}
    
    public void val_expectedCondtioWaitForTitleOfThePage() {
    	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

  	    // Wait for the title to contain "Log"
  	    wait.until(ExpectedConditions.titleContains("Log"));

  	    String actualTitle = driver.getTitle();
  	    System.out.println("Page title: " + actualTitle);

  	    // Final assertion
  	    Assert.assertEquals(actualTitle, "Log In");
		
	}
	

	

}
