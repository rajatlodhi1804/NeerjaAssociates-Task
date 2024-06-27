package EPRSystem_Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import EPRSystem.AddSalesDetail;
import Utilities.ExcelUtils;
@Test
public class AddSales extends BaseTest {
	public void addSales() throws InterruptedException, IOException {

		int entries = 10;
		AddSalesDetail sales = new AddSalesDetail(driver);
		String filePath = "E:\\Code\\org.neerjaassociates\\src\\test\\java\\Resources\\AutomationTest-1.xlsx";
		
		driver.findElement(By.xpath("//*[@title=\"PIBO Operations\"]")).click();
		driver.findElement(By.xpath("//*[@title=\"Sales Details\"]")).click();
		Thread.sleep(5000);
		
		for (int i = 0; i < entries; i++) {
			String searchRegType = ExcelUtils.readExcel(filePath, 0, i + 1, 1);
			String typeStyle = "Entity";
			String eprRegNo = "";
			String searchEntTyp = ExcelUtils.readExcel(filePath, 0, i + 1, 4);
			String searchEntNam = ExcelUtils.readExcel(filePath, 0, i + 1, 5);
			String address = ExcelUtils.readExcel(filePath, 0, i + 1, 6);
			String searchState = ExcelUtils.readExcel(filePath, 0, i + 1, 7);
			String mobileNum = ExcelUtils.readExcel(filePath, 0, i + 1, 8);
			String searchPstType = ExcelUtils.readExcel(filePath, 0, i + 1, 9);
			String searchPstCat = ExcelUtils.readExcel(filePath, 0, i + 1, 11);
			String searchcontCap = ExcelUtils.readExcel(filePath, 0, i + 1, 12);
			String searchFinYear = ExcelUtils.readExcel(filePath, 0, i + 1, 13);
			String gstNum = ExcelUtils.readExcel(filePath, 0, i + 1, 14);
			String bankAcNo = ExcelUtils.readExcel(filePath, 0, i + 1, 15);
			String ifscCode = ExcelUtils.readExcel(filePath, 0, i + 1, 16);
			String gstPaid = ExcelUtils.readExcel(filePath, 0, i + 1, 17);
			String gstInNo = ExcelUtils.readExcel(filePath, 0, i + 1, 18);
			String plastQuan = ExcelUtils.readExcel(filePath, 0, i + 1, 19);

			sales.addSales(searchRegType, typeStyle, eprRegNo, searchEntTyp, searchEntNam, address, searchState,
					mobileNum, searchPstType, searchPstCat, searchcontCap, searchFinYear, gstNum, bankAcNo, ifscCode,
					gstPaid, gstInNo, plastQuan);
		}
	}
}
