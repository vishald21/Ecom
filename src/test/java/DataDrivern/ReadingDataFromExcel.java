package DataDrivern;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException 
	{
		String excelFile="C:\\Users\\Admin\\Desktop\\study material\\Frame1.xlsx";
		FileInputStream input= new FileInputStream(excelFile);
		XSSFWorkbook workbook=new XSSFWorkbook(input);
		XSSFSheet sheet=workbook.getSheetAt(0);
		int rows=sheet.getLastRowNum();
		int coln=sheet.getRow(1).getLastCellNum();
		for(int r=0;r<=rows;r++)
		{
		XSSFRow	row=sheet.getRow(r);
			for(int c=0;c<coln;c++)
			{
				XSSFCell  cell= row.getCell(c);
				
				switch(cell.getCellType())
				{
				case STRING:System.out.print( cell.getStringCellValue());
				break;
				
				case NUMERIC:System.out.print(cell.getNumericCellValue());
				
				break;
				case BOOLEAN:System.out.print(cell.getBooleanCellValue());break;
				}
				System.out.print(" | ");
			}
			System.out.println();
		}

	}
}
