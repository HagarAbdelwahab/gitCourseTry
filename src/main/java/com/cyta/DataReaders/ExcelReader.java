package com.cyta.DataReaders;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	static String path;
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow row;
	
	private static HSSFSheet XLSWSheet;
	private static HSSFWorkbook XLSWBook;
	private static HSSFCell XLSCell;
	private static HSSFRow XLSrow;

	//load Excel file and set the sheet initially
	public static void setExcelFile(String Path, String SheetName) throws Exception{
		
		try {
			//Open the Excel file
			path= Path;
			FileInputStream ExcelFile= new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet= ExcelWBook.getSheet(SheetName);
			
		} catch (Exception e) {
			// TODO: handle exception
			throw(e);
		}	
		
	}
	
	//set or change work sheet
	public static void setExcelSheet(String SheetName) throws Exception{
		
		try {
			ExcelWSheet= ExcelWBook.getSheet(SheetName);
			
		} catch (Exception e) {
			// TODO: handle exception
			throw(e);
		}	
		
	}
	
	//load XLS file and set the sheet initially
	public static void setXLSFile(String Path, String SheetName) throws Exception{
		
		try {
			//Open the Excel file
			path= Path;
			FileInputStream ExcelFile= new FileInputStream(Path);
			XLSWBook = new HSSFWorkbook(ExcelFile);
			XLSWSheet= XLSWBook.getSheet(SheetName);
			
		} catch (Exception e) {
			// TODO: handle exception
			throw(e);
		}
		
		
	}

	//get excel file cell data by row num and col number 
	public static String getCellData(int RowNum, int ColNum) throws Exception{
		
		try {
			
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			if (Cell== null) return "";
			
			String CellData= Cell.getStringCellValue();
			return CellData;
			
		} catch (Exception e) {
			// TODO: handle exception
			throw(e);
		}
	}
	

	//get xls file cell data by row num and col number 
	public static String getXLSCellData(int RowNum, int ColNum) throws Exception{
			
			try {
				
				XLSCell = XLSWSheet.getRow(RowNum).getCell(ColNum);
				if (XLSCell== null) return "";
				
				String CellData= XLSCell.getStringCellValue();
				return CellData;
				
			} catch (Exception e) {
				// TODO: handle exception
				throw(e);
			}
		}
		
	//get excel file cell data by row name and col name 
	public String getCellData(String rowName, String columnName) {
	
		try {
				int ColNum = getColumnIndexbyName(columnName);
				int RowNum = getRowIndexbyName(rowName);
				 // return cell value given the different cell types
				 return getCellData(RowNum,ColNum);
	
			} 
		catch (Exception e) 
		{
				  return "";
		}
	}
	
	// return column number by its name
	public static int getColumnIndexbyName(String columnName) throws Exception
	{
		int coefficient=0;
	    row = ExcelWSheet.getRow(0);
	    int cellNum = row.getPhysicalNumberOfCells();
	    for (int i = 0; i < cellNum; i++) {
	        if ((row.getCell(i).toString()).equals(columnName)) {
	            coefficient = i;
	        }
	    }

	    return coefficient;
	}
	
	// return Row number by its name Excel sheet
	public static int getRowIndexbyName(String rowName) throws Exception
	{
		int coefficient=0;
	    int cellNum = ExcelWSheet.getPhysicalNumberOfRows();
	    
	    for (int i = 0; i < cellNum; i++) {
	    	
	        if ((ExcelWSheet.getRow(i).getCell(0).toString()).equals(rowName)) {
	            coefficient = i;
	        }
	    }

	    return coefficient;
	}
		
	//This function writes a certain value “Result” in a specific cell, the cell is at row RowNum and column colNum
	public static void setCellData(String Result, int RowNum, int ColNum) throws Exception{
		
		try {
			
			row=ExcelWSheet.getRow(RowNum);
			Cell=row.getCell(ColNum);
			
			if (Cell == null)
			{
				Cell=row.createCell(ColNum);
				Cell.setCellValue(Result);
			}
			else 
			{
				Cell.setCellValue(Result);
			}
			
			FileOutputStream FileOut= new FileOutputStream(path);
			ExcelWBook.write(FileOut);
			FileOut.flush();
			FileOut.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			throw(e);
		}
	}
	
	//return number of rows in excel work sheet
	public static int getNumberOfRows() {
		
		return ExcelWSheet.getPhysicalNumberOfRows();
	}
	
	//return number of columns in excel work sheet
	public static int getNumberOfColumns() {
		
		return ExcelWSheet.getRow(0).getPhysicalNumberOfCells();
	
	}
	
	//This function writes a certain value “Result” in a specific cell, the cell is at row RowNum and column colNum
	public static void setXLSCellData(String Result, int RowNum, int ColNum) throws Exception{
		
		try {
			
			XLSrow=XLSWSheet.getRow(RowNum);
			XLSCell=XLSrow.getCell(ColNum);
			
			if (Cell == null)
			{
				XLSCell=XLSrow.createCell(ColNum);
				XLSCell.setCellValue(Result);
			}
			else 
			{
				XLSCell.setCellValue(Result);
			}
			
			FileOutputStream FileOut= new FileOutputStream(path);
			XLSWBook.write(FileOut);
			FileOut.flush();
			FileOut.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			throw(e);
		}
	}
	
	//return number of rows for xls work sheet
	public static int XLSgetNumberOfRows() {
		
		return XLSWSheet.getPhysicalNumberOfRows();
	}

}
