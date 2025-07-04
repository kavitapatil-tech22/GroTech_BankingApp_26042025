package PageClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utilities.BaseClass;

public class SignUpPage extends BaseClass {
	
	WebDriver driver;
	public SignUpPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//@FindBy(xpath="(//a[@class='t-menu__link-item'])[3]")
	@FindBy(xpath="//a[@href='/registration']")
	WebElement signUp_Link;
	
	@FindBy(xpath="//input[@id='input_1495646567135']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='input_1500473664921']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='input_1495646533382']")
	WebElement phone;
	
	@FindBy(xpath="//input[@id='input_1742711839224']")
	WebElement dob;
	
	@FindBy(xpath="//select[@id='input_1742711863977']")
	WebElement selectGender;
		
	@FindBy(xpath="//input[@id='input_1742711965354']")
	WebElement cityname;
	
	@FindBy(xpath="//input[@name='User Name']")
	WebElement userId;
	
	@FindBy(xpath="//input[@name='Password']")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitButton;
	
	@FindBy(xpath="//div[@class='js-successbox t-form__successbox t-text t-text_md']")
	WebElement textMessage;
	
//
//	@FindBy(xpath="//title[text()='Registration']")
//	WebElement expectedTitleOfPage;
//	
	public void clickOnSignUp()
	{
		signUp_Link.click();
	}
		
	public void enterFirstName(String fName)
	{
		firstName.sendKeys(fName);
	}	
	public void enterLastName(String lName)
	{
		lastName.sendKeys(lName);
	}	
	public void enterPhone(String phonenum)
	{
		phone.sendKeys(phonenum);
	}	
	public void enterDOB(String dateOfBirth)
	{
		dob.sendKeys(dateOfBirth);
	}	
	public void selectGender(int x)
	{
		Select oselect=new Select(selectGender);
		oselect.selectByIndex(2);
	}	
	public void enterCityName(String city) {
		cityname.sendKeys(city);
	}
	public void enterUsedId(String userid) {
		userId.sendKeys(userid);
	}
	public void enterPassword(String Password) {
		password.sendKeys(Password);
	}	
	public void clickonSubmit()
	{
		submitButton.submit();
	}	
	public String validateMessage()
	{
		String message=textMessage.getText();
		return message;
	}
	
//	public String ExpectedTitleOfPage()
//	{
//		String ExpectedTitlemesg=expectedTitleOfPage.getText();
//		return ExpectedTitlemesg;
//	}
	
	public void val_expectedConditionWaitForSignUpButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

	    // Wait for the title to contain "Registration"
	    wait.until(ExpectedConditions.titleContains("Registration"));

	    String actualTitle = driver.getTitle();
	    System.out.println("Page title: " + actualTitle);

	    // Final assertion
	    Assert.assertEquals(actualTitle, "Registration");
		
	}
	

}
