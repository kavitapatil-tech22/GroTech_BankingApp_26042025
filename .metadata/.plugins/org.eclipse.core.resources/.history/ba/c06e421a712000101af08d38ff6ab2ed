package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
        WebElement forgetPasswrd;
        
        @FindBy(xpath = "//input[@id='input_7539084004150']")
        WebElement emailId;

        @FindBy(xpath = "//input[@id='input_7539084004151']")
        WebElement mobileNo;
        
        @FindBy(xpath = "//button[@type='submit']")
        WebElement resetbtn;
        
        
        
        @FindBy(xpath="//div[@class='js-successbox t-form__successbox t-text t-text_md']")
    	WebElement fptextMessage;

        public void forgetPasswordLink()
        {
        	forgetPasswrd.click();
        }
        public void enterEmailId(String email)
        {
        	emailId.sendKeys(email);
        }
        
        public void enterMobileNumber(String mobilenum)
        {
        	mobileNo.sendKeys(mobilenum);
        }
        public void clickOnResetBtn()
        {
               resetbtn.click();	
        }
        
        public String VerifyMessage()
        {
        	String msg2 = fptextMessage.getText();
        	
			return msg2;
        	
        }
		
}
