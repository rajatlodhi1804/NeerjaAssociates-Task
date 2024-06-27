package Utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtils {
	// Read data from Excel file
	public static String readExcel(String filePath, int sheetIndex, int rowIndex, int cellIndex) throws IOException {
		FileInputStream fileInputStream = new FileInputStream(filePath);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheetAt(sheetIndex);
		Row row = sheet.getRow(rowIndex);
		Cell cell = row.getCell(cellIndex);
		if (cell != null && cell.getCellType() == CellType.NUMERIC) {
			long cellValue = (long) cell.getNumericCellValue();
			String cellValToStr = String.valueOf(cellValue);
			workbook.close();
			fileInputStream.close();
			return cellValToStr;
		} else {
			String cellValue = cell.getStringCellValue();
			workbook.close();
			fileInputStream.close();
			return cellValue;
		}
	}

	// Write data to Excel file
	public static void writeExcel(String filePath, int sheetIndex, int rowIndex, int cellIndex, String data)
			throws IOException {
		FileInputStream fileInputStream = new FileInputStream(filePath);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheetAt(sheetIndex);
		Row row = sheet.getRow(rowIndex);
		if (row == null) {
			row = sheet.createRow(rowIndex);
		}
		Cell cell = row.getCell(cellIndex);
		if (cell == null) {
			cell = row.createCell(cellIndex);
		}
		cell.setCellValue(data);
		fileInputStream.close();

		FileOutputStream fileOutputStream = new FileOutputStream(filePath);
		workbook.write(fileOutputStream);
		fileOutputStream.close();
		workbook.close();
	}
}
