package readDataInExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ReadDataInExcel {
	@Test(dataProvider="TestCaseOfPen")
	public void ReviewTestCase(String name, String name2) {
		System.out.println(name+"------"+name2);
	}

	@DataProvider (name="TestCaseOfPen")
	public Object[][] dataSupplier() throws IOException {
		
		 File excelFile = new File(System.getProperty("user.dir") + "\\DataExcel.xlsx");
		FileInputStream fis = new FileInputStream (excelFile);
		XSSFWorkbook workbook = new XSSFWorkbook (fis);
		XSSFSheet sheet = workbook.getSheet("PenTestCase");
		int rowNumber = sheet.getLastRowNum();
		short columnNumber = sheet.getRow(0).getLastCellNum();
		Object [][] excelData = new Object [rowNumber][columnNumber];
		
		for (int r=0; r<rowNumber;r++) {
			//Store whole row
			XSSFRow row = sheet.getRow(r);
			for(int c =0; c<columnNumber;c++) {
				XSSFCell cell = row.getCell(c);
				
				CellType cellType = cell.getCellType();
				  
				 switch (cellType) {
				 case STRING :
					 // r represent the row index and c represent the column index
					 //In excelData [0][0] = store the data
					 excelData[r][c]=cell.getStringCellValue();
					 break;
					 
				 case NUMERIC:
					excelData[r][c] =Integer.toString((int) cell.getNumericCellValue());
					break;
					
				 case BOOLEAN:
					 excelData[r][c] = cell.getBooleanCellValue(); 
					break;
				 }
				
			}
		}
		return excelData;
	
		
	}

}
