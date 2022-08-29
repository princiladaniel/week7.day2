package week7.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LearnReadExcel {
	
	public static  String[][] readData(String filename) throws IOException {
	
	        //step1:setup the path for workbook
			XSSFWorkbook wbook =new XSSFWorkbook("./Data/"+filename+".xlsx");
			//step2:get into specific sheet
			XSSFSheet wsheet = wbook.getSheet("Sheet1");
			//to get the row count
			int rowcount = wsheet.getLastRowNum();//row count without header
			//to get the column count
			 short columnCount = wsheet.getRow(0).getLastCellNum();
			//Declare 2D String Array
			String[][] data=new String[rowcount][columnCount];	
			//loop
			 for (int i =1; i <=rowcount ; i++) {//row
				
				 for (int j = 0; j <columnCount ; j++) {//cell 0 1 2
					String stringCellValue = wsheet.getRow(i).getCell(j).getStringCellValue();
				    data[i-1][j]=stringCellValue;//1,0
				 }
	}
	//to close the workbook
			 wbook.close();
			 return data;
}
}
