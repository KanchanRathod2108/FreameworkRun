package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	public static void getScreenshot(WebDriver driver) throws IOException {
		
		File s =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File d = new File("C:/Users/Aakash/Desktop/SnapShot/test.bmp");
		
		FileHandler.copy(s,d);
		
	}
	
	public static String getDataFromDataSheet(int row,int cell) throws EncryptedDocumentException, IOException {
		
		String data;
		FileInputStream excel = new FileInputStream("C:/Users/Aakash/eclipse-workspace/Maven_LakhanSir_Project/Test_Data/data.xlsx");

		Sheet outData = WorkbookFactory.create(excel).getSheet("Sheet1");
		
		try {
		
		 data =outData.getRow(row).getCell(cell).getStringCellValue();
		
		}
		
		catch(Exception e) {
			
		long a= (long) outData.getRow(row).getCell(cell).getNumericCellValue();
	
		 data= (" "+a); //data Conversion of long into string
		}
		return data;
	
	
	}
}
