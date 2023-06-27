package com.naveenautomationlabs.AutomationFramework.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.AutomationFramework.Pages.AccountLogin;
import com.naveenautomationlabs.AutomationFramework.Pages.MyAccount;
import com.naveenautomationlabs.AutomationFramework.Pages.YourStore;
import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class MyAccountTest extends TestBase {

	private YourStore yourStore;
	private AccountLogin login;
	private MyAccount myAccount;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		yourStore = new YourStore();
	}
	
	@Test
	public void validateSideNavigationMenu() {
		yourStore.clickMyAccountLink();
		login = yourStore.clickLoginLink();
		myAccount = login.loginToAccount();
		myAccount.navigativeSideBar("Returns");
		Assert.assertEquals(wd.getTitle(), "Product Returns", "incorrect page");
	}
	
	@AfterMethod
	public void quit() {
		tearDown();
	}
}
