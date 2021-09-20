package com.acti.utils;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	XSSFWorkbook wb;
	
	public ExcelReader(String xlPath)
	{
		File file = new File(xlPath);
		try
		{
			FileInputStream fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	public int getRowCount(int sheetindex)
	{
		return wb.getSheetAt(sheetindex).getLastRowNum()+1;
	}
	
	//Method overloading: getRowCount with 2 different parameters!
	public int getRowCount(String sheetname)
	{
		return wb.getSheet(sheetname).getLastRowNum()+1;
		}
	
	public String getCellData(int sheetindex, int row, int cell)
	{
		 return wb.getSheetAt(sheetindex).getRow(row).getCell(cell).toString();
	}
	
	public String getCellData(String sheetname, int row, int cell)
	{
		return wb.getSheet(sheetname).getRow(row).getCell(cell).toString();
		
	}
}


