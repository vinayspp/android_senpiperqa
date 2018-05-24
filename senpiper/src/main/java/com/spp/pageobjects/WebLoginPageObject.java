package com.spp.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.spp.testdata.ConfigData;

public class WebLoginPageObject {

	public static WebDriver cd = null;

	@FindBy(how = How.CSS, using = "[name='phone']")
	WebElement usernametextbox;
	@FindBy(how = How.CSS, using = "[name='login-password']")
	WebElement passwordtextbox;
	@FindBy(how = How.CSS, using = "[type='button']")
	WebElement LoginButton;

	public WebLoginPageObject(WebDriver d) {
		cd = d;
	}

	public void login(String username, String password) {
		System.out.println("getting spp");
		cd.get(ConfigData.stagingweb);
		cd.manage().window().maximize();
		cd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		cd.manage().window().maximize();
		usernametextbox.sendKeys(username);
		passwordtextbox.sendKeys(password);
		LoginButton.click();
	}

}
