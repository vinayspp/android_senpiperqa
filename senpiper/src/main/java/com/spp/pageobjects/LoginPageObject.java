package com.spp.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.spp.tests.BaseClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


public class LoginPageObject {
	WebDriver d;
	@FindBy(how=How.ID,using = "com.senpiper.android:id/phone_edit_text")
	public WebElement username;
	@FindBy(how=How.ID,using="com.senpiper.android:id/passwordEd")
	public WebElement password;
	@FindBy(how=How.ID,using="com.senpiper.android:id/loginBtn")
	public WebElement login;
	@FindBy(how=How.ID,using="com.android.packageinstaller:id/permission_allow_button")
	WebElement allow;
	public LoginPageObject(WebDriver driver)
	{
		d=driver;
	}
	
	public void login() throws InterruptedException
	{
		username.sendKeys("7795337644");
		password.sendKeys("11111111");
		login.click();
		System.out.println("clicking allow");
		allow.click();
		System.out.println("clicked allow");
		
	}
	

}
