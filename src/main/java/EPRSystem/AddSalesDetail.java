package EPRSystem;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import WebActions.WebActions;

public class AddSalesDetail extends WebActions {
	public AddSalesDetail(WebDriver driver) {
		super(driver);
	}

	public void addSales(String searchRegType, String typeStyle, String eprRegNo, String searchEntTyp,
			String searchEntNam, String address, String searchState, String mobileNum, String searchPstType,
			String searchPstCat, String searchcontCap, String searchFinYear, String gstNum, String bankAcNo,
			String ifscCode, String gstPaid, String gstInNo, String plastQuan)
			throws InterruptedException, IOException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		Thread.sleep(15000);
		driver.findElement(By.xpath("//*[@title=\"PIBO Operations\"]")).click();
		driver.findElement(By.xpath("//*[@title=\"Sales Details\"]")).click();
		Thread.sleep(7000);

		driver.findElement(By.xpath("//*[text()='Add New ']")).click();

		String regiTypefieldName = "registration_type";
		dropDownSearchSelect(regiTypefieldName, searchRegType);

		if (typeStyle.contains("Registration Number")) {
			WebElement eprRegNoPath = driver.findElement(By.xpath("//input[@name=\"epr_reg_no\"]"));
			fieldInput(eprRegNoPath, eprRegNo);
		} else {
			driver.findElement(By.xpath("//input[@value=\"entity\"]")).click();
		}

		String entTypFieldName = "entity_type";
		dropDownSearchSelect(entTypFieldName, searchEntTyp);
		Thread.sleep(3000);

		String entNamFieldName = "registered_entity_id";
		if (searchRegType.contains("Registered")) {
			dropDownSearchSelect(entNamFieldName, searchEntNam);
		} else {
			WebElement namePath = driver.findElement(By.xpath("//input[@name=\"registered_entity_id_2\"]"));
			fieldInput(namePath, searchEntNam);
		}

		WebElement addressPath = driver.findElement(By.xpath("//input[@name=\"address\"]"));
		fieldInput(addressPath, address);

		String stateFieldName = "state_select";
		dropDownSearchSelect(stateFieldName, searchState);

		if (searchRegType.contains("Unregistered")) {
			WebElement mobilePath = driver.findElement(By.xpath("//input[@name=\"mobile_number\"]"));
			fieldInput(mobilePath, mobileNum);
		}

		String pstTypeFieldName = "plastic_type";
		dropDownSearchSelect(pstTypeFieldName, searchPstType);

		String pstCatFieldName = "plastic_category";
		dropDownSearchSelect(pstCatFieldName, searchPstCat);
		if (searchPstCat.contains("Cat I")) {
			String contCap = "cat_1_sub_cat";
			dropDownSearchSelect(contCap, searchcontCap);
		}

		String finYearFieldName = "financial_year";
		dropDownSearchSelect(finYearFieldName, searchFinYear);

		WebElement gstPath = driver.findElement(By.xpath("//input[@name=\"gst_no\"]"));
		fieldInput(gstPath, gstNum);

		WebElement bakAcPath = driver.findElement(By.xpath("//input[@name=\"account_no\"]"));
		fieldInput(bakAcPath, bankAcNo);

		WebElement ifscPath = driver.findElement(By.xpath("//input[@name=\"ifsc\"]"));
		fieldInput(ifscPath, ifscCode);

		WebElement gstPaidPath = driver.findElement(By.xpath("//input[@name=\"gst_paid\"]"));
		fieldInput(gstPaidPath, gstPaid);

		WebElement gstInNoPath = driver.findElement(By.xpath("//input[@name=\"gst_invoice\"]"));
		fieldInput(gstInNoPath, gstInNo);

		WebElement plastQuanPath = driver.findElement(By.xpath("//input[@name=\"quantity\"]"));
		fieldInput(plastQuanPath, plastQuan);

		driver.findElement(By.xpath("//*[text()='Generate EPR Invoice Number']")).click();

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("openConfirmationHeader")));
		driver.findElement(By.xpath("//*[text()='Confirm']")).click();
	}
}
