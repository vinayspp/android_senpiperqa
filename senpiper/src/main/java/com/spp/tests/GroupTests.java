package com.spp.tests;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.spp.pageobjects.GroupPageObject;
import com.spp.pageobjects.MainPageObject;

public class GroupTests extends BaseClass {
    //Test Case to create group
	@Test(priority=2)
	public void verifycCreateOpenGroup() throws InterruptedException, IOException {
		try {
			boolean flag = false;
			MainPageObject mo = PageFactory.initElements(driver, MainPageObject.class);
			flag = mo.createnewopengroup();
			Assert.assertTrue(flag);
			mo.openGroup();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void verifyCreateClosedGroup() throws InterruptedException, IOException {
		try {
			boolean flag = false;
			MainPageObject mo = PageFactory.initElements(driver, MainPageObject.class);
			flag = mo.createnewclosedgroup();
			Assert.assertTrue(flag);
			mo.openGroup();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Test case to add members to group
	@Test(priority=3)
	public void verifyaddMemberToGroup() {
		GroupPageObject gp=PageFactory.initElements(driver, GroupPageObject.class);
		gp.addmember();
	}

}
