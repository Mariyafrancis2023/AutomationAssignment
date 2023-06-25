package com.naveenautomationlabs.AutomationFramework.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.AutomationFramework.Pages.Macbook;
import com.naveenautomationlabs.AutomationFramework.Pages.YourStore;
import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class MacbookTest extends TestBase {

	YourStore yourStore;
	Macbook mac;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		yourStore = new YourStore();
	}
	
	@Test
	public void validateProductsMenu() {
		yourStore.navigateProducts("MacBook");
		Assert.assertEquals(wd.getTitle(), "MacBook");
	}
	
	@AfterMethod
	public void quit() {
		tearDown();
	}
}

