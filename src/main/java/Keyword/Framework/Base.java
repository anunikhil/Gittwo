package Keyword.Framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver init_driver( String Browser) {
		
		System.out.println("INSIDE INIT DRIVER"+Browser);
		if(Browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\anuni\\OneDrive\\anu\\work\\chromedriver.exe");
	     driver =new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("firefox"))
		{
			
		}
		else if(Browser.equalsIgnoreCase("IE")) {
			
		}
		return driver;
		
	}
	
	public Properties init_properties() {
		prop= new Properties();
		try {
			FileInputStream fp=new FileInputStream("C:\\Users\\anuni\\eclipse-workspaceNew\\Framework\\src\\main\\java\\config\\config.properties");
			prop.load(fp);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
	
			e.printStackTrace();
		}
		return prop;
		
		
	}

	 
	}

	

