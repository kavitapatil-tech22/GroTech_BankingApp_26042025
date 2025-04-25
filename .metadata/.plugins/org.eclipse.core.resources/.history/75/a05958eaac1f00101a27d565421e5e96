package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Constants.ConstantsData;

public class FetchDataFromExcel {
	
	public static String getURL() throws IOException
	{
		FileInputStream fs=new FileInputStream(ConstantsData.ExcelPath);
		XSSFWorkbook worbook=new XSSFWorkbook(fs);
		XSSFSheet sheet=worbook.getSheetAt(0);
	    XSSFCell value=	sheet.getRow(1).getCell(0);
	    String URLValue=     value.toString();
	    return URLValue;
		
		
		
		
	}
	
	

}
