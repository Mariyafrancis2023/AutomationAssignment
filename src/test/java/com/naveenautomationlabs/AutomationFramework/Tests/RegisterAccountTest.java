package com.naveenautomationlabs.AutomationFramework.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.AutomationFramework.Pages.RegisterAccount;
import com.naveenautomationlabs.AutomationFramework.Pages.YourStore;
import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class RegisterAccountTest extends TestBase{

	private YourStore yourStore;
	private RegisterAccount register;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		yourStore = new YourStore();
	}
	
	@Test
	public void validateRegisterUsingSameEmail() {
		yourStore.clickMyAccountLink();
		register = yourStore.clickRegisterLink();
		register.checkRegistration();
		Assert.assertEquals(register.getTextMsg(), "Warning: E-Mail Address is already registered!", "incorrect message");
	}
	
	@AfterMethod
	public void quit() {
		tearDown();
	}
}
