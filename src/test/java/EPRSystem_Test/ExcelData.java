package EPRSystem_Test;

import java.io.IOException;

import org.testng.annotations.Test;

import Utilities.ExcelUtils;

public class ExcelData extends BaseTest{
	@Test
	public void data() throws IOException {
		String filePath = "E:\\Code\\org.neerjaassociates\\src\\test\\java\\Resources\\AutomationTest-1.xlsx";
		
		for(int i=0; i<10; i++) {
		String name = ExcelUtils.readExcel(filePath, 0, i+1, 5);
		System.out.println(name);
		}
	}
}
