package pageClasses;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RecordPatientConditionsPage {
	//RecordPatientConditionsPage obj_RecordPatCondition=new RecordPatientConditionsPage();
	/* click patient name  */
	public static By clickPatName()
	{		
		//return By.xpath("//a[@href='/openmrs/spa/patient/b242575a-0bd2-4a50-a928-247d61b116df/chart']");		
		//return By.xpath("(//table//tr[td/a[text()='Aayansh2 patil2']])[2]");		
	/*	//a[contains(@class, 'appointments-table__link') and contains(@href, '/chart')] */		
		//return By.xpath("(//a[text()='Aayansh patil'])[2]");
		
		return By.xpath("//a[text()='Dorothy Odinga']"); //brandan mark
	}
	/* click patient name  */
	public static By clickOnConditions()
	{
		//return By.xpath("(//span[@class='-esm-patient-chart__dashboard-extension__menu___FzZxG'])[8]");	
		return By.xpath("//span[text()='Conditions']");
		
	}	/* click patient name  */
	public static By clickOnRecordConditionLink()
	{
		//return By.xpath("//button[@class='cds--btn cds--btn--sm cds--layout--size-sm cds--btn--ghost']");	
		//return By.xpath("(//button[@class='cds--btn cds--btn--sm cds--layout--size-sm cds--btn--ghost'])[1]");	
		
		// click on Add button
		return By.xpath("(//button[@class='cds--btn cds--btn--ghost' and text()='Add'])[3]");
	}
	
	
	public static By clickONSearchCondition() {
		
		//return By.xpath("//input[@class='cds--search-input']");
		//return By.xpath("//input[contains(@class, 'search-input')]");
		return By.xpath("//input[@placeholder='Search conditions']");
	}
	
	/* select option location */
	public static void slectOptionConditionName() throws AWTException {
		 /* Use Robot to navigate and select */
       Robot robot = new Robot();

       /* Press Down Arrow 1 times to reach desired option */
       robot.keyPress(KeyEvent.VK_DOWN);
       robot.keyRelease(KeyEvent.VK_DOWN);
      /* Press Enter to select */
       robot.keyPress(KeyEvent.VK_ENTER);
       robot.keyRelease(KeyEvent.VK_ENTER);
	}
	/*  click on calendar for Date Time */
	public static By clickOnCalendar() {
		//return By.xpath("//button[contains(@aria-label, 'Calendar')]");		
		//return By.xpath("//*[local-name()='button' and @id='react-aria2724544189-:r94:']");		
		return By.xpath("(//button[contains(@aria-label, 'Calendar')])");						
	}
	
	public static By enterOnSetDate() {
		return By.xpath("//input[@id='onsetDateInput']");
	}
	
	/* click on day  */
	public static By clickOnDay() {
		return (By.xpath("//span[@data-type='day']"));
	}
	/* click on Month  */
	public static By clickOnMonth() {
		return (By.xpath("//span[@data-type='month']"));
	}
	/* click on year  */
	public static By clickOnYear() {
		return (By.xpath("//span[@data-type='year']"));
	}
	
	/* Select Clicnical S)tatus */
	
	public static By selectClinicalStatus() {
		
		return By.xpath("(//span[@class='cds--radio-button__appearance'])[1]");	
	}
	public static By clickOnSaveAndClose() {
		//return By.xpath("//button[@type='submit']");
		
		return By.xpath("//button[@class='-esm-patient-conditions__conditions-form__button___lMJtM cds--btn cds--btn--primary']");
		
		
	}
	
	//private static By tableRows = By.xpath("//section[contains(@class,'tableContainer')]//tbody/tr");
	private static By tableRows = By.xpath("//section[contains(@class,'cds--data-table-container')]//thead/tr");
			
	private static By tableRows1 =By.xpath("//table[@aria-label='conditions summary']");

	public static int getConditionRowCount(WebDriver driver) {
		
		// Wait for table to load
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[contains(@class,'cds--data-table-container')]//thead/tr")));
//		
	        return driver.findElements(tableRows1).size();
	    }
	 

	 public static boolean isConditionDisplayed(String condition, String date, String status,WebDriver driver) {
//		   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//	        wait.until(d -> RecordPatientConditionsPage.getConditionRowCount(driver) > initialRowCount);
	        
//	        // Wait for table to load
//	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//	        WebElement table1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='cds--data-table -esm-patient-conditions__conditions-overview__table___NrTqj cds--data-table--sm cds--data-table--sort cds--data-table--zebra']")));

	        
	        List<WebElement> rows = driver.findElements(tableRows);
	        for (WebElement row : rows) {
	            List<WebElement> cells = row.findElements(By.tagName("td"));
	            if (cells.size() >= 3) {
	                String tableCondition = cells.get(0).getText().trim();
	                String tableDate = cells.get(1).getText().trim();
	                String tableStatus = cells.get(2).getText().trim();

	                if (tableCondition.equalsIgnoreCase(condition) &&
	                    tableDate.equalsIgnoreCase(date) &&
	                    tableStatus.equalsIgnoreCase(status)) {
	                    return true;
	                }
	            }
	        }
	        return false;
	    }
	 
	 public static String getLatestConditionValue(WebDriver driver) {
		    List<WebElement> rows = driver.findElements(tableRows);
		    return rows.get(rows.size() - 1).findElements(By.tagName("td")).get(0).getText().trim();
		}

		public static String getLatestDateValue(WebDriver driver) {
		    List<WebElement> rows = driver.findElements(tableRows);
		    return rows.get(rows.size() - 1).findElements(By.tagName("td")).get(1).getText().trim();
		}

		public static String getLatestStatusValue(WebDriver driver) {
		    List<WebElement> rows = driver.findElements(tableRows);
		    return rows.get(rows.size() - 1).findElements(By.tagName("td")).get(2).getText().trim();
		}
	 
		
		
		/*13052025  */
		
		public static void verifyConditionAdded1(WebDriver driver,String ConditionName) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

	        // STEP 1: Wait for modal to close (if it was used)
	        try {
	            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cds--modal-container")));
	        } catch (TimeoutException e) {
	            System.out.println("Modal did not close in time. Continuing anyway...");
	        }
	       
	        // STEP 2: Print all current table rows (debugging)
	        List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));
	        System.out.println("Total rows count in table: " + rows.size());
	        for (WebElement row : rows) 
	        {
	            //System.out.println("Row: " + row.getText());	            
	            String rowText = row.getText();
	            System.out.println("Row: " + rowText);            
	        }
	        // STEP 3: Try to locate condition row (relaxed XPath)
	        By conditionRow = By.xpath("//tbody/tr[contains(., '" + ConditionName + "')]");
	        try {
	            WebElement foundRow = wait.until(ExpectedConditions.visibilityOfElementLocated(conditionRow));
	            System.out.println("Condition found in table: " + foundRow.getText());
	        } catch (TimeoutException e) {
	            System.out.println("Timeout: Condition '" + ConditionName + "' not found in table.");
	            //throw new AssertionError("Condition '" + conditionName + "' was not added to the table.");
	            Assert.fail("Condition '" + ConditionName + "' was not added to the table.");
	        }
		}
		public static void verifyConditionAdded(WebDriver driver, String conditionName) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

	        // STEP 1: Wait for modal to close (if it was used)
	        try {
	            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cds--modal-container")));
	        } catch (TimeoutException e) {
	            System.out.println("Modal did not close in time. Continuing...");
	        }

	        // STEP 2: Print all current table rows (debugging)
	        List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));
	        System.out.println("Current row count: " + rows.size());
	        for (WebElement row : rows) {
	            System.out.println("Row: " + row.getText());
	        }

	        // STEP 3: Try to locate condition row (relaxed XPath)
	        By conditionRow = By.xpath("//tbody/tr[contains(., '" + conditionName + "')]");
	        try {
	            WebElement foundRow = wait.until(ExpectedConditions.visibilityOfElementLocated(conditionRow));
	            System.out.println("Condition found in table: " + foundRow.getText());
	        } catch (TimeoutException e) {
	            System.out.println("Timeout: Condition '" + conditionName + "' not found in table.");
	            throw new AssertionError("Condition '" + conditionName + "' was not added to the table.");
	        }
	    }
		
		
		/* 13052025 not using below method for reference */
//  
		/*		public static void verifyConditionAdded(WebDriver driver,String expectedConditionName,String expectedOnset,String expectedStatus ) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

	        // STEP 1: Wait for modal to close (if it was used)
	        try {
	            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cds--modal-container")));
	        } catch (TimeoutException e) {
	            System.out.println("Modal did not close in time. Continuing anyway...");
	        }
	        boolean matchFound = false;
	        // STEP 2: Print all current table rows (debugging)
	        List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));
	        System.out.println("Total rows count in table: " + rows.size());
	        for (WebElement row : rows) 
	        {
	            //System.out.println("Row: " + row.getText());	            
	            String rowText = row.getText();
	            System.out.println("Row: " + rowText);
	            List<WebElement> cells = row.findElements(By.tagName("td"));
	            if (cells.size() >= 3) 
	            {
	                String condition = cells.get(0).getText().trim();
	                String onset = cells.get(1).getText().trim();
	                String status = cells.get(2).getText().trim();
                    System.out.println("Concdition: " +condition +"Onset: "+onset +"Status :" +status );
	               if (condition.equalsIgnoreCase(expectedConditionName) &&onset.equalsIgnoreCase(expectedOnset) &&
	                    status.equalsIgnoreCase(expectedStatus)) {

	                    System.out.println("Match found: " + condition + " | " + onset + " | " + status);
	                    matchFound = true;
	                    break;
	                }
	            }
	        }
	        if (!matchFound) {
	            Assert.fail("Condition with expected values not found in the table:\nCondition: "  + expectedConditionName + "\nOnset: "
	                + expectedOnset + "\nStatus: " + expectedStatus);
	        }

	        // STEP 3: Try to locate condition row (relaxed XPath)
	        By conditionRow = By.xpath("//tbody/tr[contains(., '" + expectedConditionName + "')]");
	        try {
	            WebElement foundRow = wait.until(ExpectedConditions.visibilityOfElementLocated(conditionRow));
	            System.out.println("Condition found in table: " + foundRow.getText());
	        } catch (TimeoutException e) {
	            System.out.println("Timeout: Condition '" + expectedConditionName + "' not found in table.");
	            //throw new AssertionError("Condition '" + conditionName + "' was not added to the table.");
	            Assert.fail("Condition '" + expectedConditionName + "' was not added to the table.");
	        }
		}*/  
		
}
