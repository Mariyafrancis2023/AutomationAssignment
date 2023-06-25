package com.naveenautomationlabs.AutomationFramework.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class MyAccount extends TestBase {

	public MyAccount() {
		PageFactory.initElements(wd, this);
	}
	
	String pageTittle;
	
	@FindBy(xpath = "//div[@class='list-group']//a")
	List<WebElement> sideNavigationBarElements;
	
	public String navigativeSideBar(String sideNavElementName) {
		wait.until(ExpectedConditions.visibilityOfAllElements(sideNavigationBarElements));	
		for(int i = 0; i < sideNavigationBarElements.size(); i++) {
			if(sideNavigationBarElements.get(i).getText().equals(sideNavElementName)) {
				sideNavigationBarElements.get(i).click();
			}
		}
		return wd.getTitle(); 
	}
}
