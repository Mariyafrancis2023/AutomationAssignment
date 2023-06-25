package com.naveenautomationlabs.AutomationFramework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class AccountLogin extends TestBase {

	public AccountLogin() {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(css = "#input-email")
	private WebElement emailInput;
	
	@FindBy(css = "#input-password")
	private WebElement passwordInput;
	
	@FindBy(css = "input[value='Login']")
	private WebElement LoginBtn;
	
	public void enterEmail() {
		emailInput.sendKeys("tony@gmail.com");
	}
	
	public void enterPassword() {
		passwordInput.sendKeys("Password2");
	}
	
	public MyAccount clickLoginBtn() {
		LoginBtn.click();
		return new MyAccount();
	}
	
	public MyAccount loginToAccount() {
		enterEmail();
		enterPassword();
		return clickLoginBtn();
	}
}
