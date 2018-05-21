package com.spp.tests;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.spp.pageobjects.LoginPageObject;
import com.spp.pageobjects.MainPageObject;
public class LoginTest extends BaseClass {
    // Test Case to login in app
	@Test(priority = 1)
	public void verifylogin() throws InterruptedException, IOException {
		try {
			System.out.println("In Login Test");
			LoginPageObject l = PageFactory.initElements(driver, LoginPageObject.class);
			l.login();
			MainPageObject m = PageFactory.initElements(driver, MainPageObject.class);
			m.disabletour();
			String expectedh = m.homepageloaded();
			Assert.assertEquals(expectedh, "senpiper");

		} catch (Exception e) {
			System.out.println("in catch");
			e.printStackTrace();
			//throw (e);

		}
	}

	

	}

