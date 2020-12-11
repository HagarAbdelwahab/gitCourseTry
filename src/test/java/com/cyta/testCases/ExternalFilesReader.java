package com.cyta.testCases;

import com.cyta.DataReaders.ExcelReader;
import org.testng.annotations.Test;

public class ExternalFilesReader {

    static String path ="C:\\Users\\AboZaidH2\\Downloads\\cyta-hello\\src\\test\\resources\\Resources\\Cyta.xlsx";


    @Test
    public void testExcelReaderClassagian() throws Exception {
    ExcelReader.setExcelFile(path,"Sheet1");
    }
    @Test
    public void assign() throws Exception {
        ExcelReader.setExcelFile(path,"Sheet1");
    }




    @Test
    public void testJsonReaderClass(){
       // ExcelReader.setExcelFile();
    }

    @Test
    public void testXMLReaderClass(){

    }

    @Test
    public void testPropertiesFilesReaderClass(){

    }
    @Test
    public void testClass(){

    }
    public void tryStash(){
        //here i am
    }

}
