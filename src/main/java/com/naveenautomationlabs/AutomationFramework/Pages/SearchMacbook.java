package com.naveenautomationlabs.AutomationFramework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class SearchMacbook extends TestBase {
	
	public SearchMacbook() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(xpath = "//a[text()='MacBook']")
	private WebElement productLink;

	public Macbook clickProductLink() {
		productLink.click();
		return new Macbook();
	}

}
