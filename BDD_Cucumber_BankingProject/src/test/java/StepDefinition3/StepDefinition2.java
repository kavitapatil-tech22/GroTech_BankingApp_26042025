package StepDefinition3;

import java.awt.AWTException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import PageClasses.AccountDetailsPage;
import PageClasses.ContactsUsPage;
import PageClasses.ForgetPasswordPage;
import PageClasses.LoginPage;
import PageClasses.SignUpPage;
import Utilities.BaseClass;
//import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition2 extends BaseClass {
	
	WebDriver driver=BaseClass.initializeDriver();
	SignUpPage signp=new SignUpPage(driver);
	LoginPage login=new LoginPage(driver);
	ForgetPasswordPage obj_frgtpwd=new ForgetPasswordPage(driver);	
	//AccountDetailsPage1 obj_AccountDetail=new AccountDetailsPage1(driver);
	ContactsUsPage obj_ContactsUS=new ContactsUsPage(driver);	
	AccountDetailsPage obj_AccountDetail=new AccountDetailsPage(driver);
	
	//String ActualMessage="Thank you! Your data has been submitted.";
	
	
	/*  signup page */
	@Given("user open the url for banking application")
	public void user_open_the_url_for_banking_application() {
	    System.out.println("Application launched");
	    //System.out.println(getPageTitle());
	    String title=getPageTitle();
		 Assert.assertEquals(title,"Home");				
	}	
	@Given("user clicks on SignUp Button in WebPage")
	public void user_clicks_on_sign_up_button_in_web_page() {		
		signp.clickOnSignUp();	   
	}
	@Given("user enters the firstname as {string}")
	public void user_enters_the_firstname_as(String firstname) {		
		signp.enterFirstName(firstname);	    
	}

	@Given("user enters the lastname as {string}")
	public void user_enters_the_lastname_as(String lastname) {
		
		signp.enterLastName(lastname);	   
	}

	@Given("user enters the phonenumber as {string}")
	public void user_enters_the_phonenumber_as(String phonenumber) {
		
		signp.enterPhone(phonenumber);
		scrollDown();	  
	}

	@Given("user enters the dateofBirth as {string}")
	public void user_enters_the_dateof_birth_as(String DOB) throws InterruptedException {
			
		addHardcodedWait();
		signp.enterDOB(DOB);	    
	}

	@Given("user selects the gender")
	public void user_selects_the_gender() throws InterruptedException {
		addHardcodedWait();
		signp.selectGender(2);
	   
	}

	@Given("user enters the cityname as {string}")
	public void user_enters_the_cityname_as(String city) {
		signp.enterCityName(city);
	}

	@Given("user enters the userid as {string}")
	public void user_enters_the_userid_as(String uid) throws InterruptedException {
		addHardcodedWait();
		signp.enterUsedId(uid);
		
	}

	@Given("user enters the password as {string}")
	public void user_enters_the_password_as(String password) {
		signp.enterPassword(password);
		
		
	}
	
	@When("user clicks on Submit button")
	public void user_clicks_on_submit_button() {
	   
		scrollDown();
		signp.clickonSubmit();
		
		
	}
	@Then("validate that user is getting proper response from site")
	public void validate_that_user_is_getting_proper_response_from_site() throws InterruptedException {
		
//		addHardcodedWait();	
//		String msg=	signp.validateMessage();
//		Assert.assertEquals(ActualMessage, msg);    
		
		
		signp.val_expectedConditionWaitForSignUpButton();
	}

	@Then("also verify that the Title of the page is showing correct value")
	public void also_verify_that_the_title_of_the_page_is_showing_correct_value() {
		
		signp.val_expectedCondtioWaitForTitleOfThePage();
	}
	
//  -------------------Login ---------------------------
	@Given("user clicks on Login Button in Webpage")
	public void user_clicks_on_login_button_in_webpage() {
		login.clickOnLogin();
	}

	@Given("user enters the uname as {string}")
	public void user_enters_the_uname_as(String uid) {
		login.enterUserName(uid);
	}

	@Given("user enters the pwd as {string}")
	public void user_enters_the_pwd_as(String password) {
		login.enterPassword(password);
	}
	
	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
	    login.clickonSubmit();
	}
	
	@Then("validate that user able to login succesfully")
	public void validate_that_user_able_to_login_succesfully() throws InterruptedException {		
		login.val_expectedConditionWaitForLoginButton();	
	}

	@Then("also verify that the Title of the Login page is shown proper")
	public void also_verify_that_the_title_of_the_login_page_is_shown_proper() {

	  login.val_expectedCondtioWaitForTitleOfThePage();	  	 		
	}
	
//------------------------Forgot Password -------------------------------
	
	@Given("user clicks on the forgot password link Button")
	public void user_clicks_on_the_forgot_password_link_button() {
		obj_frgtpwd.forgetPasswordLink();
	}
	
	@Given("user enters email id as {string}")
	public void user_enters_email_id_as(String EmailId) {
		obj_frgtpwd.enterEmailId(EmailId);
	}

	@Given("user enters mobile number as {string}")
	public void user_enters_mobile_number_as(String Phonenum) {
		obj_frgtpwd.enterMobileNumber(Phonenum);
	}

	@When("user clicks on Reset button")
	public void user_clicks_on_reset_button() {
		obj_frgtpwd.clickOnResetBtn();
	}

	@Then("validate that user able to reset forgot password succesfully")
	public void validate_that_user_able_to_reset_forgot_password_succesfully() {
		
		obj_frgtpwd.val_expectedConditionWaitForResetButton();		
	}

	@Then("also verify that the Title of the forgot password page is shown proper")
	public void also_verify_that_the_title_of_the_forgot_password_page_is_shown_proper() {
	    
		obj_frgtpwd.val_expectedCondtioWaitForTitleOfThePage();
		
	}
	
	//--------------------------Account Details--------------
	
/*	
@Given("user clicks on Account Detail Button in Webpage")
public void user_clicks_on_account_detail_button_in_webpage() {	
		obj_AccountDetail.clickOnAccountDetails_Link();		        
}*/
	
//@Given("user switch to new window")
//public void user_switch_to_new_window() {
////		String mainWindow = driver.getWindowHandle();
////		Set<String> allWindows = driver.getWindowHandles();
////
////		// Loop through all windows
////		for (String handle : allWindows) {
////		    if (!handle.equals(mainWindow)) {
////		        // Switch to the new window
////		        driver.switchTo().window(handle);
////		        System.out.println("Switched to new window: " + driver.getTitle());
////		        
////		    }
////		}
//		
//		String original = driver.getWindowHandle();
//		//Sdriver.findElement(By.id("openDashboard")).click();
//
//		for (String windowHandle : driver.getWindowHandles()) {
//		    if (!original.contentEquals(windowHandle)) {
//		        driver.switchTo().window(windowHandle);
//		        break;
//		    }
//		}
//		System.out.println("Switched to new window: " +driver.getTitle());
//	}
/*
@Given("user clicks on the dropdown Your Name")
public void user_clicks_on_the_dropdown_your_name() {
	
	//obj_AccountDetail.selectCustomDropdown3();
	
	obj_AccountDetail.selectCustomDropdown3();	
	
}*/
/* working code
@Given("user selects the Your Name")
public void user_selects_the_Your_Name() {
	//addHardcodedWait();
	//obj_AccountDetail.selectYourName(3);
	
	//obj_AccountDetail.selectDropdownOption1(3);
		
	// obj_AccountDetail.selectDropdownOptionByIndex(3);
			 
	
	obj_AccountDetail.selectDropdownOptionByIndex();
	
	
	
	//obj_AccountDetail.selectCustomDropdown2();
	
	//obj_AccountDetail.selectCustomDropdown1();
}*/
/*
@When("user clicks on the Login Button")
public void user_clicks_on_the_login_button() {
	obj_AccountDetail.clickonLoginButton();
}*/


/*
@Then("validate that user able to view banking page succesfully")
public void validate_that_user_able_to_view_banking_page_succesfully() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

    // CSS selector matching the element that contains the success message
    By successMsgLocator = By.cssSelector("span.Welcome, 2!");

    // Wait until the success message appears and contains expected text
    wait.until(ExpectedConditions.textToBePresentInElementLocated(successMsgLocator, "'Welcome"));

    WebElement successMsgElement = driver.findElement(successMsgLocator);
    String actualMessage = successMsgElement.getText();

    System.out.println("Actual message: " + actualMessage);

    // Assertion
    Assert.assertEquals(actualMessage.trim(), "Welcome, 2!");
} */

/*  working code
@Then("also verify that the Title of the banking page shown proper")
public void also_verify_that_the_title_of_the_banking_page_shown_proper() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    // Wait for the title to contain "HOME | banking"
    wait.until(ExpectedConditions.titleContains("HOME | banking"));

    String actualTitle = driver.getTitle();
    System.out.println("Page title: " + actualTitle);

    // Final assertion
    Assert.assertEquals(actualTitle, "HOME | banking");
}
 */

/*
@Then("user selects the Account Number")
public void user_selects_the_account_number() throws InterruptedException {
	addHardcodedWait();
	obj_AccountDetail.selectAccountNumber(2);
}*/


//
//@When("user clicks on the deposit tab")
//public void user_clicks_on_the_deposit_tab() {
//	obj_AccountDetail.clickOnTabDeposit();
//}
//
//@When("user enters the deposit amount as {string}")
//public void user_enters_the_deposit_amount_as(String DepositAmount) {
//	obj_AccountDetail.enterDepositAmount(DepositAmount);
//}
//
//
//@When("user clicks on the Deposit button")
//public void user_clicks_on_the_deposit_button()
//{
//	obj_AccountDetail.clickOnDepositButton();
//}
//
////@Then("validate the user able to seee deposited amount in balance field")
////public void validate_the_user_able_to_seee_deposited_amount_in_balance_field() {
////    
////}
//
//@When("user clicks on the Withdrawl tab")
//public void user_clicks_on_the_withdrawl_tab() {
//	obj_AccountDetail.clickOnTabWithdrawal();
//}
//
//@When("user enters the withdraw amount as {string}")
//public void user_enters_the_withdraw_amount_as(String WithdrawAmount) {
//	obj_AccountDetail.enterWithdrawalAmount(WithdrawAmount);
//}
//
//@When("user clicks on the Withdrawl button")
//public void user_clicks_on_the_withdrawl_button() {
//	obj_AccountDetail.clickOnWithdrawalButton();
//}

//@Then("validate the user able to seee remaning balanced amount in balance field")
//public void validate_the_user_able_to_seee_remaning_balanced_amount_in_balance_field() {
//    
//}

//@Then("user clicks on the Reset button")
//public void user_clicks_on_the_reset_button() {
//	obj_AccountDetail.clickOnbtnReset();
//}
//
////@Then("validate the user able to navigate back to page successfully")
////public void validate_the_user_able_to_navigate_back_to_page_successfully() {
//// 
////}
//
//@Then("also verify that title of the bank page shown proper")
//public void also_verify_that_title_of_the_bank_page_shown_proper() {
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//
//    // Wait for the title to contain "Registration"
//    wait.until(ExpectedConditions.titleContains("HOME | banking"));
//
//    String actualTitle = driver.getTitle();
//    System.out.println("Page title: " + actualTitle);
//
//    // Final assertion
//    Assert.assertEquals(actualTitle, "HOME | banking");
//}

	
	
	/*   Contacts Us----------------------*/

@Given("user clicks on ContactsUs Button in Webpage")
public void user_clicks_on_contacts_us_button_in_webpage() {
	obj_ContactsUS.clickOnContactsUsLink();
}

@Given("user enters the username as {string}")
public void user_enters_the_username_as(String YourName) {
	obj_ContactsUS.enterYourName(YourName);
}

@Given("user enters the email as {string}")
public void user_enters_the_email_as(String emailId) {
	obj_ContactsUS.enterEmail(emailId);
}

@Given("user enters the phoneNum as {string}")
public void user_enters_the_phone_num_as(String phoneNum) {
	obj_ContactsUS.enterPhoneNum(phoneNum);
}

@Given("user enters the address as {string}")
public void user_enters_the_address_as(String address) {
	obj_ContactsUS.enterAddress(address);
}

@Given("user enters the country as {string}")
public void user_enters_the_country_as(String country) {
	obj_ContactsUS.enterCountry(country);
}

@Given("user enters the zipCode as {string}")
public void user_enters_the_zip_code_as(String zipCode) {
	obj_ContactsUS.enterZipCode(zipCode);
}

@When("user clicks on Button Submit")
public void user_clicks_on_button_submit() throws InterruptedException {
	
	obj_ContactsUS.clickOnButton_Submit();
}

@Then("validate that user able to submit succesfully")
public void validate_that_user_able_to_submit_succesfully() {
	
	obj_ContactsUS.val_expectedConditionWaitForSubmitButton();
		
}

	
@Then("also verify that the Title of the ContactsUs page is shown proper")
public void also_verify_that_title_of_the_bank_page_shown_proper() {

//	((ContactsUsPage) obj_ContactsUS).val_expectedCondtioWait();
    obj_ContactsUS.val_expectedCondtioWaitForTitleOfThePage();
}


/*       Account Details 3   ------------*/

@Given("user clicks on AccountDetails button in Webpage")
public void user_clicks_on_account_details_button_in_webpage() throws InterruptedException {
	
	obj_AccountDetail.click_on_Link_AccountDetails();
	switchToChildWindow(driver);
	
	addHardcodedWait();
	System.out.println(driver.getCurrentUrl());
	
	}

@Given("user select customer from the dropdown")
public void user_select_customer_from_the_dropdown() throws AWTException, InterruptedException {
	//Thread.sleep(2000);
	obj_AccountDetail.enterYourName();
}

@Given("user clicks on the Login Button")
public void user_clicks_on_the_login_button() {
	obj_AccountDetail.submit_Login();
}

@Given("user selects the Account Number")
public void user_selects_the_account_number() throws InterruptedException {
	addHardcodedWait();
	
	obj_AccountDetail.selectAccountNumber(3);
}

@Given("user clicks on the Deposit tab")
public void user_clicks_on_the_deposit_tab() {
	obj_AccountDetail.clickOn_tablabel_DepositButton();
}

@Given("user enters the amount as {string}")
public void user_enters_the_amount_as(String DepositAmount) {
	addExplicitWait(By.xpath("(//span[@class='TabsList2027980309__label'])[2]"));
	obj_AccountDetail.enterAmount(DepositAmount);
}

@When("user submit the deposit Button")
public void user_submit_the_deposit_button() {
	obj_AccountDetail.ClickOn_btn_submitDeposit();
}

@Then("deposited amount is updated in balance field")
public void deposited_amount_is_updated_in_balance_field() {
	
	String txt_Deposited_Balance=addValidateMessage(By.xpath("//div[@id='comp-m8szvc14']"));	
	Assert.assertEquals(txt_Deposited_Balance ,"Balance :");
	System.out.println(txt_Deposited_Balance);
	
//	String actualBalanceString="5000";
//String txt_Deposited_Balance=addValidateMessage(By.xpath("//div[@id='comp-m8szvc14']"));	
//	String expected = "Balance : " + txt_Deposited_Balance.toString();
//	Assert.assertEquals(expected, actualBalanceString);
//	System.out.println("Balance : "+ txt_Deposited_Balance.toString());
		
}

@Then("user clicks on withdrawl tab")
public void user_clicks_on_withdrawl_tab() throws InterruptedException {
	Thread.sleep(2000);
	obj_AccountDetail.clickOn_tablabel_WithdrawAmount();
}

@Then("user enters amount to be withdrawn as {string}")
public void user_enters_amount_to_be_withdrawn_as(String WithdrawAmount) throws InterruptedException {
	Thread.sleep(2000);
	obj_AccountDetail.enterWithdrawalAmount(WithdrawAmount);
}

@When("click on withdraw Button")
public void click_on_withdraw_button() throws InterruptedException {
	Thread.sleep(2000);
	obj_AccountDetail.clickOn_btn_WithdrawAmount();
}

@Then("deducted balanced amount is updated in balance field")
public void deducted_balanced_amount_is_updated_in_balance_field() {
	
	String txt_Deducted_Balance=addValidateMessage(By.xpath("//div[@id='comp-m8szvumq']"));
	Assert.assertEquals(txt_Deducted_Balance ,"₹4000");
	System.out.println(txt_Deducted_Balance);
	
    // String txt_Deducted_Balance=addValidateMessage(By.xpath("//div[@id='comp-m8szvumq']"));	
	//Assert.assertEquals(txt_Deducted_Balance ,"₹4000");
	//System.out.println("After Deduction Updated Balance : "+ txt_Deducted_Balance.toString());
}

@Then("also verify that the Title of the AccountDetails page is shown proper")
public void also_verify_that_the_title_of_the_account_details_page_is_shown_proper() {
	obj_AccountDetail.val_expectedCondtioWaitForTitleOfThePage();
}






















}
