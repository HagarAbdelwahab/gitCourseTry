package com.cyta.testCases;

import java.util.List;
import org.testng.annotations.DataProvider;
import com.cyta.Constants.Constants;
import com.cyta.DataReaders.ExcelReader;
import com.cyta.DataReaders.JSONReader;
import com.cyta.DataReaders.PropertiesReader;
import com.cyta.DataReaders.XMLReader;
import org.testng.annotations.Test;

public class TestReaders {
 
  @Test(dataProvider = "DP")
  public void f(String Test) {
	  
	  System.out.println(Test);
	  
	  PropertiesReader.readProperties(Constants.ConfigPath+"TestConfigs.properties");
	  System.out.println(PropertiesReader.getPropertyValue("key"));
	  
	  JSONReader.readJSONdoc(Constants.testDataPath+"employees.json");
	  List<String> JSONvalues= JSONReader.getValueByName("employee", "firstName");
	  for (int i=0; i<JSONvalues.size();i++)
	  {
		System.out.println(JSONvalues.get(i));
	  }
	  
	  XMLReader.readXMLdoc(Constants.testDataPath+"XMLFile.xml");
	  List<String> XMLvalues= XMLReader.getValueByNodeName("student", "id");
	  for (int i=0; i<XMLvalues.size();i++)
	  {
		System.out.println(XMLvalues.get(i));
	  }
	  
  }
  
  @DataProvider 
  //@Description("Data Provider ")
  public Object[][] DP() throws Exception {
	  
	 /*Header1*/
	  ExcelReader.setExcelFile(Constants.testDataPath+"Cyta.xlsx","Sheet1");
	  Object[][] object= new Object[ExcelReader.getNumberOfRows()-1][ExcelReader.getNumberOfColumns()];
	  
	  //without The header
	  for (int i=1; i<ExcelReader.getNumberOfRows();i++)
	  {
		  for(int j=0;j<ExcelReader.getNumberOfColumns();j++)  
		  {
			  object[i-1][j]=ExcelReader.getCellData(i,j);
		  }
	  }
	   return object;
	 }
  
  @DataProvider 
  //@Description("Data Provider ")
  public Object[] DP2() throws Exception {
	  
	 /*Header1*/
	  ExcelReader.setExcelFile(Constants.testDataPath+"Cyta.xlsx","Sheet1");
	  Object[] object= new Object[1];
	  int ColumnIndex= ExcelReader.getColumnIndexbyName("Header1");
	  int RowIndex= ExcelReader.getRowIndexbyName("Test Reading from xlsx");
	  object[0]=ExcelReader.getCellData(RowIndex,ColumnIndex);
	  return object;
	  
	 }
}
