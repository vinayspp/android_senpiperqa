package com.spp.pageobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.spp.utilities.CommonMethods;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
public class MainPageObject {
	WebDriver d;
	public MainPageObject(WebDriver driver) {
		this.d = driver;
	}

	@FindBy(how = How.ID, using = "com.senpiper.android:id/conversationWithTxt")
	WebElement Senppr;
	@FindBy(how = How.ID, using = "com.senpiper.android:id/joinStoreButton")
	WebElement joingroup;
	@FindBy(how = How.ID, using = "com.senpiper.android:id/sliding_menu_tab_layout")
	WebElement chats;
	@FindBy(how = How.ID, using = "com.senpiper.android:id/menu_overflow")
	WebElement contextmenu;
	@FindBy(how = How.ID, using = "com.senpiper.android:id/title")
	List<WebElement> options;
	@FindBy(how = How.ID, using = "com.senpiper.android:id/textViewEnterGroupName")
	WebElement groupname;
	@FindBy(how = How.ID, using = "com.senpiper.android:id/switchOpenGroup")
	WebElement grouptype;
	@FindBy(how = How.ID, using = "com.senpiper.android:id/group_info_edit_text_activity_create_group")
	WebElement groupinfo;
	@FindBy(how = How.ID, using = "com.senpiper.android:id/itemCreateGroup")
	WebElement creategrp;
	@FindBy(how = How.ID, using = "com.senpiper.android:id/itemNext")
	WebElement next;
	@FindBy(how = How.ID, using = "com.senpiper.android:id/textViewGroupName")
	List<WebElement> groups;

	public String homepageloaded() {
		WebDriverWait w = new WebDriverWait(d, 30);
		w.until(ExpectedConditions.visibilityOf(Senppr));
		System.out.println("in homepage");
		String s = Senppr.getText();
		return s;
	}

	public void disabletour() throws InterruptedException {
		System.out.println(chats.isDisplayed());
		TouchAction a2 = new TouchAction((PerformsTouchActions) d);
		a2.tap(413, 560).perform();

	}

	public boolean createnewgroup() {

		boolean flag = false;
		contextmenu.click();
		for (WebElement op : options) {
			if (op.getText().contains("Create"))
				op.click();
			break;
		}
		String gpname = CommonMethods.getDateTime();
		groupname.sendKeys(gpname);
		grouptype.click();
		groupinfo.sendKeys(gpname);
		next.click();
		creategrp.click();
		//check if the created group exists
		for (WebElement gr : groups) {
			if (gr.getText().contains(gpname)) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	public void openGroup()
	{
		for(WebElement gr: groups)
		{
			gr.click();
			break;
		}
		
	}

}
