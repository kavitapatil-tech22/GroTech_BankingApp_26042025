package testClasses;
import java.awt.AWTException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageClasses.PatientEndVisitPage;
import utilities.BaseClass;

public class PatientEndVisitTest extends BaseClass
{
	@Test(priority=2,groups={"sanity"},retryAnalyzer = utilities.RetryAnalyzer.class)
	public static void excuteEndVsistPatient() throws InterruptedException, AWTException
	{
	
		LoginTest.executeLoginTest();
		Thread.sleep(10000);

		scrollToTableHeader(driver);

		addExplicitWait3(PatientEndVisitPage.clickPatName());
		driver.findElement(PatientEndVisitPage.clickPatName()).click();
		
		scrollToTop(driver);
		Thread.sleep(3000);
		
		// Step 1: Click the Actions button
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement actionsButton = wait.until(ExpectedConditions.elementToBeClickable(PatientEndVisitPage.clickOnActions()));
		actionsButton.click();
		
		// Step 2: Wait for one of the menu items to appear (e.g., "End active visit")
		By addVisitOption = By.xpath("//div[contains(@class, 'cds--overflow-menu-options__option-content') and text()='End active visit']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(addVisitOption));
		
		// Step 3: Optionally click it
		driver.findElement(addVisitOption).click();
		
		// Wait until the modal is visible
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("cds--modal-header")));
		
		// Click the EndVisit button
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement btn_endVisit = wait2.until(ExpectedConditions.elementToBeClickable(PatientEndVisitPage.clickOnModelPopEndVisitButton()));
		btn_endVisit.click();
		
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(50));
		By ClickOnOpenMrs=By.xpath("//a[@href='/openmrs/spa/home']");
		wait3.until(ExpectedConditions.elementToBeClickable(ClickOnOpenMrs));
	    driver.findElement(ClickOnOpenMrs).click();
	    
	    scrollToBottom(driver);
        scrollToBottom(driver);
       // Thread.sleep(3000); 
		
        String patientName = "Indic Test"; // Replace with actual dynamic name

        // Validate the patient is no longer visible
        PatientEndVisitPage.verifyPatientIsDeleted(patientName, driver);

        System.out.println("Test Passed: Patient '" + patientName + "' is not present in the Active Visit table.");
    
	}

	
}
