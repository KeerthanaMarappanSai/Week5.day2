package week6.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelData {
	@Test
	public static String[][] readData(String excelFileName) throws IOException
	{
		//Open excel sheet
		XSSFWorkbook book=new XSSFWorkbook("./testData/"+excelFileName+".xlsx");
		//Get the sheet where data is available
		XSSFSheet sheet = book.getSheetAt(0);
		//Get row count
		int rowCount = sheet.getLastRowNum();
		//Get column count
		XSSFRow headerRow = sheet.getRow(0);
		short colCount = headerRow.getLastCellNum();
		
		String[][] data=new String [rowCount][colCount];
		for(int i=1;i<=rowCount;i++)
		{
			//Get each row out of the sheet
			XSSFRow eachRow = sheet.getRow(i);
			
			for(int j=0;j<colCount;j++)
			{
				//Get each cell
				XSSFCell eachCell = eachRow.getCell(j);
				String cellData = eachCell.getStringCellValue();
				System.out.print(cellData+ "\t");
				data[i-1][j]=cellData;
			}
			
			System.out.println();
		
		}
		return data;
		
	}

}
