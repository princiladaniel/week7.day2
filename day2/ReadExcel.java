package week7.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel {
   @Test
	public void readdata(String fileName) throws IOException {
		//step1:setup the path for workbook
		XSSFWorkbook wbook =new XSSFWorkbook("./Data/"+fileName+".xlsx");
		//step2:get into specific sheet
		XSSFSheet wsheet = wbook.getSheet("Sheet1");
		//by index
		//XSSFSheet wsheetAt = wbook.getSheetAt(0);//read the first sheet
		//to get the row count
		int rowcount = wsheet.getLastRowNum();
		//to get the column count
		
		 short columnCount = wsheet.getRow(0).getLastCellNum();
		 System.out.println(rowcount);
		 System.out.println(columnCount);
		 //Get the specified row
		 XSSFRow firstrow = wsheet.getRow(1);
		 //Get a specified cell(column)
		 XSSFCell cell = firstrow.getCell(1);
		 //to get the data from the cell
		 String stringCellValue = cell.getStringCellValue();
		 System.out.println(stringCellValue);
		//----------------------------------------------------------- 
		 for (int i = 1; i <=rowcount ; i++) {
			 XSSFRow row = wsheet.getRow(i);
		 for (int j = 0; j <columnCount ; j++) {
			 XSSFCell TotalCell= row.getCell(j);
			 System.out.println(TotalCell.getStringCellValue());
			
		}
	}

}
}
