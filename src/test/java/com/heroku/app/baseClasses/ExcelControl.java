package com.heroku.app.baseClasses;

import java.io.File;
import java.io.FileInputStream;

// import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelControl extends BasePage{
    
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private Row row;
    // private Cell cell;
    protected Object[][] data;

    private File file;
    private FileInputStream inputStream;

    public Object[][] getLoginData(){
        try{
            file = new File(System.getProperty("user.dir")+File.separator+"src\\test\\java\\com\\heroku\\app\\Utility\\data.xlsx");
            inputStream = new FileInputStream(file);

            workbook = new XSSFWorkbook(inputStream);
            sheet = workbook.getSheetAt(0);

            data = new Object[sheet.getLastRowNum()-1][2];

            for(int i=2;i<=sheet.getLastRowNum();i++){
                row = sheet.getRow(i);
                if(row!=null){
                    String username = row.getCell(0).getStringCellValue();
                    String password = row.getCell(1).getStringCellValue();
                    
                    data[i -2][0] = username;
                    data[i -2][1] =  password;
                }
            }


        }
        catch(Exception e){
            e.printStackTrace();
        }
        return data;
    }


}
