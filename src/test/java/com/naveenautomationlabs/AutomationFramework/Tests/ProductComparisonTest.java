package com.naveenautomationlabs.AutomationFramework.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.AutomationFramework.Pages.ProductComparison;
import com.naveenautomationlabs.AutomationFramework.Pages.YourStore;
import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class ProductComparisonTest extends TestBase {

	private YourStore yourStore;
	private ProductComparison compare;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		yourStore = new YourStore();
	}
	
	@Test
	public void validateProductComparison() {
		yourStore.clickCompareProductBtn();
		compare = yourStore.clickCompareProductLink();
		Assert.assertEquals(compare.getPageHeading(), "Product Comparison", "incorrect text");
	}
	
	@AfterMethod
	public void quit() {
		tearDown();
	}
}

