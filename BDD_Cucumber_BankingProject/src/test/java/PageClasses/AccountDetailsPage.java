package PageClasses;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AccountDetailsPage {
	
	WebDriver driver;
	public AccountDetailsPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
	
	
	@FindBy(xpath="//a[text()='Account Detail']")
	WebElement link_AccountDetails;
	
	
	@FindBy(xpath="//select[@id='collection_comp-m8swuunx']")
	WebElement select_YourName;
	
	@FindBy(xpath="//span[contains(text(), 'Login')]")
	WebElement btn_Login;
	
	@FindBy(xpath="//select[@id='collection_comp-m8sxryjj']")
	WebElement select_AccountNum;
	
	@FindBy(xpath="(//span[@class='TabsList2027980309__label'])[2]")
	WebElement tablabel_Deposit;
	
	@FindBy(xpath="//input[@id='input_comp-m8t00o79']")
	WebElement amount;
	
	@FindBy(xpath="(//span[text()='Deposit'])[2]")
	WebElement btn_SubmitDeposit;
	
	
	@FindBy(xpath="(//span[@class='TabsList2027980309__label'])[3]")
	WebElement tablabel_Withdrawal;

	@FindBy(xpath="//input[@id='input_comp-m8t03jwk']")
	WebElement withdrawalAmount;
	
	@FindBy(xpath="(//button[@class='_NpZMS wixui-button PlZyDq'])[3]")
	WebElement clickOnBtn_Withdraw;
		
	@FindBy(xpath = "//div[@class='RJZaGO']")
	WebElement dropdownContainer;

	@FindBy(xpath = "//div[text()='Rahul']")
	WebElement optionRahul;

	public void enterYourName() {
	    dropdownContainer.click();
	    optionRahul.click();
	}
	
	public void click_on_Link_AccountDetails()
	{
		link_AccountDetails.click();
	}
	
	
//	public void enterYouName() throws AWTException 
//	{
//
//		Robot sw = new Robot();
//		sw.keyPress(KeyEvent.VK_DOWN);
//		sw.keyPress(KeyEvent.VK_ENTER);
//		 sw.delay(100);
//		 select_YourName.click();
//		 sw.delay(100);
//		sw.keyPress(KeyEvent.VK_DOWN);
//		sw.keyPress(KeyEvent.VK_DOWN);
//		sw.keyPress(KeyEvent.VK_ENTER);
//		
//	}
	
	public void submit_Login()
	{
		btn_Login.click();
	}
	
	public void selectAccountNumber(int accountNum)
	{				
		Select oselect=new Select(select_AccountNum);
		oselect.selectByIndex(3);
	}	
	public void clickOn_tablabel_DepositButton()
	{
		tablabel_Deposit.click();
	}
	
	public void enterAmount(String deposit_amount)
	{
		 amount.sendKeys(deposit_amount);
	}
	public void ClickOn_btn_submitDeposit()
	{
		btn_SubmitDeposit.click();
	}
	public void clickOn_tablabel_WithdrawAmount()
	{
		tablabel_Withdrawal.click();
	}
	public void enterWithdrawalAmount(String withdrawal_amount)
	{
		withdrawalAmount.sendKeys(withdrawal_amount);
	}
	public void clickOn_btn_WithdrawAmount() {
		clickOnBtn_Withdraw.click();
	}
	
	public void val_expectedCondtioWaitForTitleOfThePage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

	    // Wait for the title to contain "Registration"
	    wait.until(ExpectedConditions.titleContains("HOME | banking"));

	    String actualTitle = driver.getTitle();
	    System.out.println("Page title: " + actualTitle);

	    // Final assertion
	    Assert.assertEquals(actualTitle, "HOME | banking");
		
	}
}
