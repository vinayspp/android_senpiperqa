package com.spp.tests;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.spp.pageobjects.GroupPageObject;
import com.spp.pageobjects.MainPageObject;

public class GroupTests extends BaseClass {

	@Test(priority=2)
	public void verifycreategroup() throws InterruptedException, IOException {
		try {
			boolean flag = false;
			MainPageObject mo = PageFactory.initElements(driver, MainPageObject.class);
			flag = mo.createnewgroup();
			Assert.assertTrue(flag);
			mo.openGroup();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=3)
	public void verifyaddMemberToGroup() {
		GroupPageObject gp=PageFactory.initElements(driver, GroupPageObject.class);
		gp.addmember();
	}

}
