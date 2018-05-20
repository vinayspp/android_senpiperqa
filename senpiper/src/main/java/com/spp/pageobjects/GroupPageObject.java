package com.spp.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GroupPageObject {

	WebDriver d;

	public GroupPageObject(WebDriver d) {
		this.d = d;
	}

	@FindBy(how = How.ID, using = "com.senpiper.android:id/menu_overflow")
	WebElement group_context_menu;
	@FindBy(how = How.ID, using = "com.senpiper.android:id/textViewGroupName")
	List<WebElement> settings;
	@FindBy(how = How.ID, using = "com.senpiper.android:id/addNewGroupMemberImageButton")
	WebElement add_member;
	@FindBy(how = How.ID, using = "com.senpiper.android:id/tv_employee_name")
	List<WebElement> Employee_List;
	@FindBy(how = How.ID, using = "com.senpiper.android:id/conversationWithTxt")
	WebElement group_head;

	public void addmember() {
		group_head.click();
		add_member.click();
		int no_of_members = Employee_List.size();
		while (no_of_members > 0) {
			for (WebElement em : Employee_List) {
				em.click();
				add_member.click();
				no_of_members--;
			}
		}
	}

}
