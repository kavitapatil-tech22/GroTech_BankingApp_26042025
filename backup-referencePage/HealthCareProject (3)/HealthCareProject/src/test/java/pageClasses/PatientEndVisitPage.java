package pageClasses;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PatientEndVisitPage {
	
	/* click patient name  */
	public static By clickPatName()
	{				
		//return By.xpath("//a[text()='Dorothy Odinga']");  //Grace Garcia
		//return By.xpath("//a[text()='Richard Jones']");
		//return By.xpath("//a[text()='Donald Harris']");   //indic Test
		return By.xpath("//a[text()='Indic Test']");
	}	
	public static By clickOnModelPopEndVisitButton()
	{				
		 return By.xpath("//button[contains(@class, 'cds--btn cds--btn--danger') and text()='End Visit']");
	}

	/* below code is working fine and accessed in PatientEndVisitTest */
	/*  the after end visit appointment for patient , to validate the the  patient name should not present in the table  */
	public static void verifyPatientIsDeleted(String patientName, WebDriver driver) {
	    List<WebElement> links = driver.findElements(By.cssSelector("a[href*='/openmrs/spa/patient/']"));
	    
	    for (WebElement link : links) {
	        if (link.getText().trim().equalsIgnoreCase(patientName)) {
	            // Patient was found – extract ID for the error message
	            String href = link.getAttribute("href");
	            String patientId = href.split("/patient/")[1].split("/")[0];
	            
	            // Throw assertion error because patient should be deleted but was found
	            throw new AssertionError("Patient '" + patientName + "' was found in the appointment table with ID: " + patientId + ". Expected patient to be deleted.");
	        }
	    }

	    // If we get here, the patient was NOT found — success
	    System.out.println("Patient '" + patientName + "' is not present in the appointment table. Deletion successful.");
	}

	/*  click on location */
	public static By clickOnActions()
	{		
		 return By.id("custom-actions-overflow-menu-trigger");
	}
	
	/* select option for Actions  */
	public static void selectOptionActions() throws AWTException {
		 /* Use Robot to navigate and select */
       Robot robot = new Robot();

       /* Press Down Arrow 1 times to reach desired option */
       robot.keyPress(KeyEvent.VK_DOWN);
       robot.keyRelease(KeyEvent.VK_DOWN);
       robot.keyPress(KeyEvent.VK_DOWN);
       robot.keyRelease(KeyEvent.VK_DOWN);
       robot.keyPress(KeyEvent.VK_DOWN);
       robot.keyRelease(KeyEvent.VK_DOWN);
       
      /* Press Enter to select */
       robot.keyPress(KeyEvent.VK_ENTER);
       robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	
}
