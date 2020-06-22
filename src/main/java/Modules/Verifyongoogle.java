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

public class Verifyongoogle extends AppDriver
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
	public Verifyongoogle()
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
    @FindBy (xpath = "//a[contains(text(),'Principal')]/parent::span/following-sibling::span")  WebElement Eleprincipal;
    @FindBy (xpath = "//a[contains(text(),'Founded')]/parent::span/following-sibling::span")  WebElement Elefounded;
    @FindBy (xpath = "//a[contains(text(),'Affiliation')]/parent::span/following-sibling::span")  WebElement EleAffiliation;
	
	public void createexcel(String path, String name) throws IOException
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
		row.createCell(7).setCellValue("Principal");
   		row.createCell(8).setCellValue("Founded");
   		row.createCell(9).setCellValue("Affiliation");
		fos = new FileOutputStream(src); 
		wb.write(fos);	
	}
	public void sendtogoogle(String inputexcelsheet) throws IOException, InterruptedException
	{
		int lastrow = Readwriteexcel.getlastrownum(inputexcelsheet, 0);
		for(int i =1; i<lastrow; i++)
		{
		String data = Readwriteexcel.readexcel(inputexcelsheet, 0, i, 0);
		System.out.println("Row num started " + i);
		googelsearchbox.clear();
		googelsearchbox.sendKeys(data);
		Actions act = new Actions(driver); 
   		act.sendKeys(Keys.ENTER).build().perform(); 
   		Thread.sleep(1000);
   		m();
		}
	}
	public void m() throws InterruptedException, IOException
   	{    	
   	for(int i =0; i<list.size(); i++)
   	{
   		((JavascriptExecutor)driver).executeScript("scroll(10,400)");
   		list.get(i).click();
   		Thread.sleep(3000);
   		row = sheet.createRow((short)count.getAndIncrement());
   		
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
   		try
   		{
   			Principal = Eleprincipal.getText();
   		row.createCell(7).setCellValue(Principal);
   		fos = new FileOutputStream(src); 
   		wb.write(fos);
   		}
   		catch(Exception e)
   		{
   			try
   			{
   				Principal = driver.findElement(By.cssSelector("body.srp.tbo.vasq:nth-child(2) div.rfli.mdm:nth-child(3) div.BBj6N:nth-child(12) div.col:nth-child(3) div.rhstc5 div.r-iYSmFJGakXPQ:nth-child(2) div.iYSmFJGakXPQ-jWD6pBvCV60.h2yBfgNjGpc__inline-item-view.r-iCW_xhUARSoI async-local-kp.iCW_xhUARSoI-AjwZTeXvKls.r-iMpgniV_zCxk div.iMpgniV_zCxk-AjwZTeXvKls.y.yf div.immersive-container:nth-child(2) div.akp_tsuid3.akp-el div.t3HED div.g.kno-kp.mnr-c.g-blk div.kp-blk.knowledge-panel.Wnoohf.OJXvsb div.xpdopen div.ifM9O:nth-child(1) div:nth-child(2) div.mod:nth-child(4) div.Z1hOCe div.zloOqf.PZPZlf.kno-fb-ctx > span.LrzXr.kno-fv")).getText();
   				row.createCell(7).setCellValue(Principal);
   				fos = new FileOutputStream(src); 
   				wb.write(fos);
   			}
   			catch(Exception e9)
   			{
   				
   			}
   		}
   			
   		try
   		{
   		Founded = Elefounded.getText();
   		row.createCell(8).setCellValue(Founded);
   		fos = new FileOutputStream(src); 
   		wb.write(fos);
   		}
   		catch(Exception e)
   		{
   			try
   			{
   				Founded = driver.findElement(By.cssSelector("body.srp.tbo.vasq:nth-child(2) div.rfli.mdm:nth-child(3) div.BBj6N:nth-child(12) div.col:nth-child(3) div.rhstc5 div.r-iYSmFJGakXPQ:nth-child(2) div.iYSmFJGakXPQ-jWD6pBvCV60.h2yBfgNjGpc__inline-item-view.r-iCW_xhUARSoI async-local-kp.iCW_xhUARSoI-AjwZTeXvKls.r-iMpgniV_zCxk div.iMpgniV_zCxk-AjwZTeXvKls.y.yf div.immersive-container:nth-child(2) div.akp_tsuid3.akp-el div.t3HED div.g.kno-kp.mnr-c.g-blk div.kp-blk.knowledge-panel.Wnoohf.OJXvsb div.xpdopen div.ifM9O:nth-child(1) div:nth-child(2) div.mod:nth-child(4) div.Z1hOCe div.zloOqf.PZPZlf.kno-fb-ctx > span.LrzXr.kno-fv")).getText();
   				row.createCell(8).setCellValue(Founded);
   				fos = new FileOutputStream(src); 
   				wb.write(fos);
   			}
   			catch(Exception e9)
   			{
   				
   			}
   		}
   		try
   		{
   	Affiliation = EleAffiliation.getText();
   		row.createCell(9).setCellValue(Affiliation);
   		fos = new FileOutputStream(src); 
   		wb.write(fos);
   		}
   		catch(Exception e)
   		{
   			try
   			{
   				Affiliation = driver.findElement(By.cssSelector("body.srp.tbo.vasq:nth-child(2) div.rfli.mdm:nth-child(3) div.BBj6N:nth-child(12) div.col:nth-child(3) div.rhstc5 div.r-iYSmFJGakXPQ:nth-child(2) div.iYSmFJGakXPQ-jWD6pBvCV60.h2yBfgNjGpc__inline-item-view.r-iCW_xhUARSoI async-local-kp.iCW_xhUARSoI-AjwZTeXvKls.r-iMpgniV_zCxk div.iMpgniV_zCxk-AjwZTeXvKls.y.yf div.immersive-container:nth-child(2) div.akp_tsuid3.akp-el div.t3HED div.g.kno-kp.mnr-c.g-blk div.kp-blk.knowledge-panel.Wnoohf.OJXvsb div.xpdopen div.ifM9O:nth-child(1) div.mod:nth-child(5) div.Z1hOCe div.zloOqf.PZPZlf.kno-fb-ctx span.LrzXr.kno-fv > a.fl:nth-child(1)")).getText();
   				row.createCell(9).setCellValue(Affiliation);
   				fos = new FileOutputStream(src); 
   				wb.write(fos);
   			}
   			catch(Exception e9)
   			{
   				
   			}
   		}
   	}
   	
   	list.clear();	
   	
   	k();
   	}
   public void k() throws InterruptedException, IOException
   {
   	try
   	{
   	driver.findElement(By.cssSelector("#pnnext>span")).click();
   	   Thread.sleep(3000);
   	   m();
   	   //h();
   	}
   	catch(Exception e)
   	{
   		System.out.println("completed");
   	}
   }   
	
}
