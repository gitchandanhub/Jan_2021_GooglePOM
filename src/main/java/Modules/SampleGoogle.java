package Modules;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.AppDriver;
import ExcelUtility.Readwriteexcel;

public class SampleGoogle extends AppDriver
{
	File src;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	FileOutputStream fos;
	String website = "";
	String Principal = "";
	String Affiliation = "";
	String Appointment = "";
	String Founded = "";
	String City = "";
	String url = "";
	AtomicInteger count = new AtomicInteger(1);
	AtomicInteger count2 = new AtomicInteger(1);
	public SampleGoogle()
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath = "//*[@id='lst-ib']") WebElement googelsearchbox; 
	@FindAll (@FindBy (css = ".dbg0pd>div"))  List<WebElement> list;
    @FindBy (xpath = ".//*[@class = 'b9tNq']/following-sibling::div")  WebElement Elename;
    @FindBy (xpath = ".//*[starts-with(@id, 'akp_tsuid')]/div/div[1]/div/div/div/div[1]/div/div[1]/div/div[3]/div/div[2]/div/div/span[2]") WebElement  EleAddress;
    @FindBy (css = ".LrzXr.zdqRlf.kno-fv") WebElement Elenumber;
    @FindBy (xpath = ".//*[@class = 'CL9Uqc ab_button'  and contains(text(), 'Website')]")  WebElement Elewebsite;
    @FindBy (xpath = "//span[contains(text(),'Appointments:')]/following-sibling::a") WebElement appointment;
	
	public void createurlexcel(String path, String name) throws IOException
	{
		src = new File(path+name+".xlsx");
		wb = new XSSFWorkbook();
		sheet = wb.createSheet("wp_details");
		row = sheet.createRow((short)0);  
		row.createCell(0).setCellValue("city");
		row.createCell(1).setCellValue("url");
		row.createCell(2).setCellValue("Category");
	   fos = new FileOutputStream(src);
		wb.write(fos);
	}
	public void CreatedbExcel(String path, String name) throws IOException
    {
    	src = new File(path+name+".xlsx");
		wb = new XSSFWorkbook(); 
		sheet = wb.createSheet("ME_details");	
		row = sheet.createRow((short)0);  
		row.createCell(0).setCellValue("Name");
		row.createCell(1).setCellValue("Address");
		row.createCell(2).setCellValue("Number");
		row.createCell(3).setCellValue("website");
		row.createCell(4).setCellValue("City");
		row.createCell(5).setCellValue("Category");
		row.createCell(6).setCellValue("Appointments");
		fos = new FileOutputStream(src); 
		wb.write(fos);
    }
	
	public void fetchurl(String citysheetpath, String categorysheetpath) throws InterruptedException, IOException
	{
		int cityrownum = Readwriteexcel.getlastrownum(citysheetpath, 0);
		int categoryrownum = Readwriteexcel.getlastrownum(categorysheetpath, 0);
		for(int i =1; i<cityrownum+1; i++)
		{
		String city = Readwriteexcel.readexcel(citysheetpath, 0, i, 0);
		for(int j =1; j<18; j++)
		{
		   String category = Readwriteexcel.readexcel(categorysheetpath, 0, j, 0);
		String input = category+ " " +"in"+ " "+city;
		googelsearchbox.clear();
		googelsearchbox.sendKeys(input);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(3000);
		String requiredurl = driver.getCurrentUrl();
		row = sheet.createRow((short)count2.getAndIncrement());  
		row.createCell(0).setCellValue(city);
		row.createCell(1).setCellValue(requiredurl);
		row.createCell(2).setCellValue(category);
		fos = new FileOutputStream(src);
		wb.write(fos);
		}
		}
	}
	public void fetchdata(String urlexcelpath, String urlexcelname) throws IOException, InterruptedException
	{
		Thread.sleep(3000);
		int urlrownum = Readwriteexcel.getlastrownum(urlexcelpath+urlexcelname+".xlsx", 0);
		System.out.println(urlrownum);
		for(int i =1; i<urlrownum; i++)
		{
		City = Readwriteexcel.readexcel(urlexcelpath+urlexcelname+".xlsx", 0, i, 0);
		String url = Readwriteexcel.readexcel(urlexcelpath+urlexcelname+".xlsx", 0, i, 1);
		String category = Readwriteexcel.readexcel(urlexcelpath+urlexcelname+".xlsx", 0, i, 2);
		driver.navigate().to(url);
		Thread.sleep(2000);
		System.out.println("Url no : -" + i);
		h(City, category);
		}
		}
		public void h(String City, String category) throws InterruptedException, IOException
		{

			System.out.println(list.size());
	    	if(list.size()==0)
	    	{
	    		googelsearchbox.click();
	    		Actions act = new Actions(driver); 
	    		act.sendKeys(Keys.ENTER).build().perform(); 
	    		m(City, category);
	    		
	    	}
	    	else
	    	{
	    		m(City , category);
	    	}
	    	list.clear();
	    }
		public void m(String city, String category) throws InterruptedException, IOException
       	{    	
       	for(int i =0; i<list.size(); i++)
       	{
       		((JavascriptExecutor)driver).executeScript("scroll(10,400)");
       		list.get(i).click();
       		Thread.sleep(2000);
       		row = sheet.createRow((short)count.getAndIncrement());
       		row.createCell(4).setCellValue(city);
       		row.createCell(5).setCellValue(category);
       		fos = new FileOutputStream(src); 
       		wb.write(fos);
       		try
       		{
       			String name = list.get(i).getText();
       			row.createCell(0).setCellValue(name);
       			fos = new FileOutputStream(src); 
       			wb.write(fos);
       		}
       		catch(Exception e2)
       		{
       			try
       			{
       				int  t = i+1;
       				String name = driver.findElement(By.xpath("//*[@id='rl_ist0']/div[1]/div[4]/div["+t+"]/div/div[2]/div/a/div/div[2]/div")).getText();
       				row.createCell(0).setCellValue(name);
       				fos = new FileOutputStream(src); 
       				wb.write(fos);
       			}
       			catch(Exception e3)
       			{
       				try
       				{
       					String name = Elename.getText();
       					row.createCell(0).setCellValue(name);
       					fos = new FileOutputStream(src); 
       					wb.write(fos);
       				}
       				catch(Exception e8)
       				{
       					
       				}
       			}
       		}
       		try
       		{
       			String address = EleAddress.getText();
       			row.createCell(1).setCellValue(address);
       			fos = new FileOutputStream(src); 
       			wb.write(fos);
       		}
       		catch(Exception e4)
       		{
       			try
       			{
       				String address = driver.findElement(By.cssSelector(".LrzXr")).getText();
       				row.createCell(1).setCellValue(address);
       				fos = new FileOutputStream(src); 
       				wb.write(fos);
       			}
       			catch(Exception e5)
       			{
       				
       			}
       		}
       		try
       		{
       			String number = Elenumber.getText();
       			row.createCell(2).setCellValue(number);
       			fos = new FileOutputStream(src); 
       			wb.write(fos);
       		}
       		catch(Exception e6)
       		{
       			try
       			{
       				String number = driver.findElement(By.xpath(".//*[@class = 'w8qArf']/following-sibling::span/a")).getText();
       				row.createCell(2).setCellValue(number);
       				fos = new FileOutputStream(src); 
       				wb.write(fos);
       			}
       			catch(Exception e7)
       			{
       				try
       				{
       					String number = driver.findElement(By.cssSelector(".LrzXr.zdqRlf.kno-fv>span>span")).getText();
       					row.createCell(2).setCellValue(number);
       					fos = new FileOutputStream(src); 
       					wb.write(fos);	
       				}
       				catch(Exception e8)
       				{
       					try
       					{
       						String number = driver.findElement(By.xpath(".//*[@class = 'LrzXr zdqRlf kno-fv']")).getText();
       						row.createCell(2).setCellValue(number);
       						fos = new FileOutputStream(src); 
       						wb.write(fos);
       					}
       					catch(Exception e11)
       					{
       						
       					}
       				}
       			}
       		}
       		try
       		{
       			website = driver.findElement(By.xpath("//a[contains(text(),'Website')]")).getAttribute("href");
       			row.createCell(3).setCellValue(website);
       			fos = new FileOutputStream(src); 
       			wb.write(fos);
       		}
       		catch(Exception e)
       		{
       			try
       			{
       				website = Elewebsite.getAttribute("href");
       				row.createCell(3).setCellValue(website);
       				fos = new FileOutputStream(src); 
       				wb.write(fos);
       			}
       			catch(Exception e9)
       			{
       				try
       				{
       					website = driver.findElement(By.cssSelector(".CL9Uqc.ab_button")).getAttribute("href");
       					row.createCell(3).setCellValue(website);
       					fos = new FileOutputStream(src); 
       					wb.write(fos);
       				}
       				catch(Exception e10)
       				{
       					
       				}
       			}
       		}
       		    			
       		
       		try
       		{
       			Appointment = appointment.getText();
       			row.createCell(6).setCellValue(Appointment);
       			fos = new FileOutputStream(src); 
       			wb.write(fos);
       		}
       		catch(Exception e)
       		{
       			try
       			{
       				Appointment = driver.findElement(By.cssSelector("body.srp.tbo.vasq:nth-child(2) div.rfli.mdm:nth-child(3) div.BBj6N:nth-child(12) div.col:nth-child(3) div.rhstc5 div.r-iYSmFJGakXPQ:nth-child(2) div.iYSmFJGakXPQ-jWD6pBvCV60.h2yBfgNjGpc__inline-item-view.r-iCW_xhUARSoI async-local-kp.iCW_xhUARSoI-AjwZTeXvKls.r-iMpgniV_zCxk div.iMpgniV_zCxk-AjwZTeXvKls.y.yf div.immersive-container:nth-child(2) div.akp_tsuid3.akp-el div.t3HED div.g.kno-kp.mnr-c.g-blk div.kp-blk.knowledge-panel.Wnoohf.OJXvsb div.xpdopen div.ifM9O:nth-child(1) div.mod:nth-child(5) div.Z1hOCe div.zloOqf.PZPZlf.kno-fb-ctx span.LrzXr.kno-fv > a.fl:nth-child(1)")).getText();
       				row.createCell(6).setCellValue(Appointment);
       				fos = new FileOutputStream(src); 
       				wb.write(fos);
       			}
       			catch(Exception e9)
       			{

       			}
       		}
       	}
       	
       	list.clear();	
       	
       	k(city, category);
       	}
       public void k(String city, String category) throws InterruptedException, IOException
       {
       	try
       	{
       	driver.findElement(By.cssSelector("#pnnext>span")).click();
       	   Thread.sleep(2000);
       	   m(city, category);
       	   //h();
       	}
       	catch(Exception e)
       	{
       		System.out.println("completed");
       	}
       }   
   	
	
}
