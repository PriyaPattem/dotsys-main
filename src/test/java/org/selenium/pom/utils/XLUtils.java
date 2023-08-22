package org.selenium.pom.utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public  class XLUtils {




    public FileInputStream fi;
    public  FileOutputStream fo;
    public XSSFWorkbook wb;
    public XSSFSheet ws;
    public XSSFRow row;
    public XSSFCell cell;



    public    int getRowCount(String xlfile,String xlsheet) throws IOException
    {

        fi=new FileInputStream(xlfile);
        wb=new XSSFWorkbook(fi);
        ws=wb.getSheet(xlsheet);
        int rowcount=ws.getLastRowNum();
        if(rowcount==-1){
            return 0;
        }
        wb.close();
        fi.close();
        return rowcount;
    }


    public   int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException
    {
        fi=new FileInputStream(xlfile);
        wb=new XSSFWorkbook(fi);
        ws=wb.getSheet(xlsheet);
        row=ws.getRow(rownum);
        int cellcount=row.getLastCellNum();
        wb.close();
        fi.close();
        return cellcount;
    }


    public   String getCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
    {
        fi=new FileInputStream(xlfile);
        wb=new XSSFWorkbook(fi);
        ws=wb.getSheet(xlsheet);
        row=ws.getRow(rownum);
        cell=row.getCell(colnum);
        String data;
        try
        {
            DataFormatter formatter = new DataFormatter();
            String cellData = formatter.formatCellValue(cell);
            return cellData;
        }
        catch (Exception e)
        {
            data="";
        }
        wb.close();
        fi.close();
        return data;
    }

    public   void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
    {
        File xlfile1=new File(xlfile);
        if(!xlfile1.exists())    // If file not exists then create new file
        {
            wb=new XSSFWorkbook();
            fo=new FileOutputStream(xlfile);
            wb.write(fo);
        }

        fi=new FileInputStream(xlfile);
        wb=new XSSFWorkbook(fi);

        if(wb.getSheetIndex(xlsheet)==-1) // If sheet not exists then create new Sheet
            wb.createSheet(xlsheet);
        ws=wb.getSheet(xlsheet);

        if(ws.getRow(rownum)==null)   // If row not exists then create new Row
            ws.createRow(rownum);
        row=ws.getRow(rownum);

        cell=row.createCell(colnum);
        cell.setCellValue(data);
        fo=new FileOutputStream(xlfile1);
        wb.write(fo);
        wb.close();
        fi.close();
        fo.close();
    }


}

