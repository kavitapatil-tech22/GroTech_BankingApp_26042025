package PageClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utilities.BaseClass;

public class ContactsUsPage extends BaseClass
{
        WebDriver driver;        
        public ContactsUsPage(WebDriver driver)       
        {
              this.driver = driver;
              PageFactory.initElements(driver, this);
        	
         }
        
        @FindBy(xpath="//a[@href='/contact-us']")
        WebElement link_ContactsUs;
        
        @FindBy(xpath = "//input[@placeholder=\"Your name\"]")
        WebElement txt_yourName;
        
        @FindBy(xpath = "//input[@placeholder='Your e-mail']")
        WebElement txt_emailId;

        @FindBy(xpath = "//input[@placeholder='Phone Number']")
        WebElement txt_phoneNo;
        
        @FindBy(xpath = "//input[@placeholder='Address']")
        WebElement txt_address;
        
        @FindBy(xpath = "//input[@placeholder='Country']")
        WebElement txt_country;
        
        @FindBy(xpath = "//input[@placeholder='Zip Code']")
        WebElement txt_zipCode;
       
        @FindBy(xpath = "//button[@type='submit']")
        WebElement btn_Submit;     

        
        public void clickOnContactsUsLink() {
        	link_ContactsUs.click();
        }
        
        public void enterYourName(String yourname) {
        	txt_yourName.sendKeys(yourname);
        }
        public void enterEmail(String email) {
        	txt_emailId.sendKeys(email);
        }
        public void enterPhoneNum(String phonenum) {
        	txt_phoneNo.sendKeys(phonenum);
        }
        public void enterAddress(String address) {
        	txt_address.sendKeys(address);
        }
        public void enterCountry(String country) {
        	txt_country.sendKeys(country);
        }
        public void enterZipCode(String zipcode) {
        	txt_zipCode.sendKeys(zipcode);
        }
        
        public void clickOnButton_Submit() {
        	btn_Submit.click();
        }
        
       
		

		public void val_expectedConditionWaitForSubmitButton() {
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
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

      	  // Wait for the title to contain "Registration"
      	  wait.until(ExpectedConditions.titleContains("Contacts"));

      	  String actualTitle = driver.getTitle();
      	  System.out.println("Page title: " + actualTitle);

      	  // Final assertion
      	  Assert.assertEquals(actualTitle, "Contacts");
			
		}
}
