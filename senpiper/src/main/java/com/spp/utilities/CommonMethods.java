package com.spp.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.spp.pageobjects.WebLoginPageObject;
import com.spp.tests.BaseClass;

public class CommonMethods extends BaseClass{

	public static void swipeVertically(int swipeValue) {

		try {
			int swipeHight = 0;
			swipeHight = swipeValue;
			Dimension screenSize = driver.manage().window().getSize();

			int screenWidth = screenSize.getWidth() / 2;
			int screenHight = screenSize.getHeight() / 2;
			if (screenHight + swipeValue > screenHight * 2 || swipeValue == 0) {
				swipeHight = screenHight / 2;

			}

		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}
	
	
	public static void takescreenshot(WebDriver driver,String path,String methodname) throws IOException
	{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(path+methodname+".png"));
	}
	
	public static String getDateTime()
	{
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); // 2016/11/16 12:08:43
		String now = dateFormat.format(date);
		return now;
	}
	
	public static void spploginchrome()
	{
		System.out.println("inspplogin");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\zopper\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
		 WebDriver cd = new ChromeDriver();
		 WebLoginPageObject web=PageFactory.initElements(cd, WebLoginPageObject.class);
		 web.login("demov2@zopper.com", "11111111");
	}
	
	public static void spploginfirefox()
	{
		
	}
}
