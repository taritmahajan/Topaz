package com.tam.utility.FileUtil;

import org.apache.poi.xssf.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTableColumn;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExcelManager {

    String excelPath = System.getProperty("user.dir") + "/src/test/resources/TestData/TestData.xlsx";
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    FileInputStream fis;
    String testName;

    public ExcelManager(String sheetname) throws IOException {
        fis =  new FileInputStream(excelPath);
        this.workbook = new XSSFWorkbook(fis);
        this.sheet = this.workbook.getSheet(sheetname);
    }

    public ExcelManager(String sheetname,String testName) throws IOException {
        fis =  new FileInputStream(excelPath);
        this.workbook = new XSSFWorkbook(fis);
        this.sheet = this.workbook.getSheet(sheetname);
        this.testName = testName;
    }

    public String getCellData(int row,int cel){
        return this.sheet.getRow(row).getCell(cel).getStringCellValue();
    }

    public int numOfRows(){
        return this.sheet.getLastRowNum();
    }

    public int numOfColumns(){
        return this.sheet.getRow(0).getPhysicalNumberOfCells();
    }

    public String getDataByColumnName(String columnName,String rowName){

        if(!listOfColumns().contains(columnName)){
            System.out.println("no such column name " + columnName);
            return null;
        }

        int positionOfValue = 0;
        int positionOfRowName = 0;

        for(int i=0; i<numOfColumns();i++) {
            //System.out.println(getCellData(0,i));
            if (getCellData(0, i).equals(columnName)){
                //System.out.println("position  is  " + i);
                positionOfValue = i;
                break;
            }
        }

        for(int i=1; i<=numOfRows();i++) {
            //System.out.println(getCellData(0,i));
            if (getCellData(i, 0).equals(rowName)){
                //System.out.println("position  is  " + i);
                positionOfRowName = i;
                break;
            }
        }
        return getCellData(positionOfRowName,positionOfValue);      //need to change this 1 to row name
    }

    public String getDataByColumnName(String dataName){

        if(!listOfColumns().contains(dataName)){
            System.out.println("no such column name " + dataName);
            return null;
        }

        int positionOfValue = 0;
        int positionOfRowTitle = 0;

        for(int i=0; i<numOfColumns();i++) {
            if (getCellData(0, i).equalsIgnoreCase(dataName)){
                positionOfValue = i;
                break;
            }
        }

        for(int i=1; i<=numOfRows();i++) {
            if (getCellData(i, 0).equalsIgnoreCase(this.testName)){
                positionOfRowTitle = i;
                break;
            }
        }
        return getCellData(positionOfRowTitle,positionOfValue);      //need to change this 1 to row name
    }


    public List<String> listOfColumns(){
        ArrayList<String> columnList = new ArrayList<String>();
        try {

           for (int i = 0; i < numOfColumns(); i++) {
               columnList.add(getCellData(0, i));
           }

       }catch (NullPointerException e){
           e.printStackTrace();
       }

        return columnList;
    }

}
