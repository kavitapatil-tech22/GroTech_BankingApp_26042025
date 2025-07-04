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

public class ForgetPasswordPage extends BaseClass
{
        WebDriver driver;        
        public ForgetPasswordPage(WebDriver driver)       
        {
              this.driver = driver;
              PageFactory.initElements(driver, this);
        	
         }
        
        @FindBy(xpath="(//a[@class='t-menu__link-item'])[6]")
        WebElement link_forgetPassword;
        
        @FindBy(xpath = "//input[@id='input_7539084004150']")
        WebElement txt_emailId;

        @FindBy(xpath = "//input[@id='input_7539084004151']")
        WebElement txt_mobileNo;
        
        @FindBy(xpath = "//button[@type='submit']")
        WebElement btn_reset;     
        
        @FindBy(xpath="//div[@class='js-successbox t-form__successbox t-text t-text_md']")
    	WebElement val_forgotPwd_txtMessage;

        public void forgetPasswordLink()
        {
        	link_forgetPassword.click();
        }
        public void enterEmailId(String email)
        {
        	txt_emailId.sendKeys(email);
        }
        
        public void enterMobileNumber(String mobilenum)
        {
        	txt_mobileNo.sendKeys(mobilenum);
        }
        public void clickOnResetBtn()
        {
        	btn_reset.click();	
        }
        
        public String VerifyMessage()
        {
        	String msg2 = link_forgetPassword.getText();
        	
			return msg2;
        	
        }
        
        public void val_expectedConditionWaitForResetButton() {
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
        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

    	    // Wait for the title to contain "Registration"
    	    wait.until(ExpectedConditions.titleContains("Forget Password"));

    	    String actualTitle = driver.getTitle();
    	    System.out.println("Page title: " + actualTitle);

    	    // Final assertion
    	    Assert.assertEquals(actualTitle, "Forget Password");
			
		}
		
}
