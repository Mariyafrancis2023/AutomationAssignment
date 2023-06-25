package com.naveenautomationlabs.AutomationFramework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class ProductComparison extends TestBase{

	public ProductComparison() {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(css = "#content h1")
	WebElement pageHeading;
	
	public String getPageHeading() {
		return pageHeading.getText();
	}
}
