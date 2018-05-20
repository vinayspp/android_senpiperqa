package com.spp.tests;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.spp.utilities.CommonMethods;

import io.appium.java_client.android.AndroidDriver;

public class BaseClass {
	
	public static AndroidDriver driver;
	@BeforeTest
	public void setup() throws MalformedURLException
	{
		File app = new File("C:\\Users\\zopper\\Desktop\\sppapp", "spp.apk");
		 DesiredCapabilities capability = new DesiredCapabilities();
		 capability.setCapability("device","Android");
		 capability.setCapability(CapabilityType.BROWSER_NAME, "");
		 capability.setCapability(CapabilityType.VERSION, "6.0");
		 capability.setCapability("app", app.getAbsolutePath());
		 capability.setCapability("deviceName","Moto G");
		 capability.setCapability("platformName","Android");
		 capability.setCapability("app-package", "com.senpiper.android-1");
		 capability.setCapability("app-activity", "com.senpiper.android.ActivityLogin");
		 driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capability);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	
	@AfterMethod
	public void onTestFailure(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			System.out.println(testResult.getStatus());
			System.out.println("hitting scrn");
			CommonMethods.takescreenshot(driver, "D:\\screens\\", testResult.getMethod().getMethodName());
		}}

}
