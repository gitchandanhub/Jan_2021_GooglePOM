package Modules;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.AppDriver;
import ExcelUtility.Readwriteexcel;

public class GoogleUrl extends AppDriver
{
	File src;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	FileOutputStream fos;
	AtomicInteger count = new AtomicInteger(1);
        public GoogleUrl()
        {
        	PageFactory.initElements(driver, this);
        }
        
       @FindBy (xpath = "//*[@id='lst-ib']") WebElement googelsearchbox; 
     
        public void CreateExcel(String path) throws IOException
        {
        	src = new File(path);
    		wb = new XSSFWorkbook(); 
    		sheet = wb.createSheet("wp_details");	
    		row = sheet.createRow((short)0);  
    		row.createCell(0).setCellValue("city");
    		row.createCell(1).setCellValue("url");
    	    fos = new FileOutputStream(src); 
    		wb.write(fos);
        }
        
        public void GetUrl(String Citypath, int citysheetindex, int startcity, int citylength,  String Categorypath, int categorysheetindex,  int categorylength) throws IOException, InterruptedException
        {
        	for(int i = startcity; i<citylength; i++)
        	{
        		String city = Readwriteexcel.readexcel(Citypath, citysheetindex, i, 0);
        		for(int j =0; j<categorylength; j++)
        		{
        			String category = Readwriteexcel.readexcel(Categorypath, categorysheetindex, j, 0);
        			String input = category+ " " +"in"+ " "+city;
        			System.out.println(input);
        			googelsearchbox.clear();
        			googelsearchbox.sendKeys(input);
        			Actions act = new Actions(driver); 
        			act.sendKeys(Keys.ENTER).build().perform(); 
        			Thread.sleep(2000);
        			String requiredurl = driver.getCurrentUrl();
        			row = sheet.createRow((short)count.getAndIncrement());  
        			row.createCell(0).setCellValue(city);
        			row.createCell(1).setCellValue(requiredurl);
        			row.createCell(2).setCellValue(category);
        		    fos = new FileOutputStream(src); 
        			wb.write(fos);
        		}
        	}
        }
}
