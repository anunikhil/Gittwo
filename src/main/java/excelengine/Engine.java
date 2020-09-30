package excelengine;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Keyword.Framework.Base;

public class Engine  {
	
	public WebDriver driver;
	public Properties prop;
	public static Sheet sheet;
	public static Workbook book;
	public Base base;
	
	public final String test_path="C:\\Users\\anuni\\eclipse-workspaceNew\\Framework\\src\\main\\java\\Scenarios\\test.xlsx";
	
	public void StartExecution(String sheetName ) {
		System.out.println("inside engine");
		String locatorname=null;
		String locatorvalue=null;
		FileInputStream file=null;
		try {
			file =new  FileInputStream(test_path);
			 book =WorkbookFactory.create(file);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int size= book.getNumberOfSheets();
		  sheet =book.getSheet(sheetName);
		  int k=0;
		  System.out.println(sheet.getLastRowNum());
		  for(int i=0;i<4;i++)
		  {
			  System.out.println(sheet.getLastRowNum());
			  System.out.println("the valu of i"+i);
			  System.out.println("inside for loop");
			  String locator=sheet.getRow(i+2).getCell(k+1).toString().trim();
			  System.out.println("The value of locator is "+locator);
			  try {
			  if(!locator.equalsIgnoreCase("NA"))
			  {
				  locatorname=locator.split("=")[0].trim();
				 locatorvalue = locator.split("=")[1].trim();
				 System.out.println(locatorvalue);
			  }
			  String Action = sheet.getRow(i+2).getCell(k+2).toString().trim();
			  System.out.println("the value of action"+Action);
			  String value = sheet.getRow(i+2).getCell(k+3).toString().trim();
			  System.out.println("the value of value "+value);
			  
			  
			  switch(Action) {
			  case "open":
				  base=new Base();
			prop= base.init_properties();
			String browser=prop.getProperty("browser");
			driver=base.init_driver(browser);
			//driver.get("https://www.google.com/");
				//driver=Base.init_driver(prop.getProperty("browser"));
				  break;
			  case "get url":
				 System.out.println("get url case");
				 driver.get("https://www.google.com/");
				  driver.get(value);
			  				  
				  default:
					  break;
				  
			  }
			  if(!locator.equalsIgnoreCase("NA")) {
			  switch(locatorname) {
			  case "name":
				  System.out.println("THEvalue of locator"+locatorvalue);
				  WebElement element=driver.findElement(By.name("q"));
				 // WebElement element=driver.findElement(By.name(locatorvalue));
				  if(Action.equalsIgnoreCase("sendkeys")) {
					  element.clear();
					  element.sendKeys(value);
					  
				  }else if(Action.equalsIgnoreCase("click")) {
						element.click();  
					  }
						  
				  }
			  }
			  }catch(Exception e) {
				  e.printStackTrace();
			  }
			  }
			  
		  }
		
	}
	


