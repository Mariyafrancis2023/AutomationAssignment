package com.naveenautomationlabs.AutomationFramework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class RegisterAccount extends TestBase  {

	public RegisterAccount() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "#input-firstname")
	private WebElement firstNameInput;

	@FindBy(css = "#input-lastname")
	private WebElement lastNameInput;

	@FindBy(css = "#input-email")
	private WebElement emailInput;
	
	@FindBy(css = "#input-telephone")
	private WebElement numberInput;
	
	@FindBy(css = "#input-password")
	private WebElement passwordInput;
	
	@FindBy(css = "#input-confirm")
	private WebElement passwordConfirmInput;
	
	@FindBy(css = "input[type='checkbox']")
	private WebElement privacyCheckbox;
	
	@FindBy(css = "input[value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath = "//div[@class='text-danger']")
	private WebElement getMessageText;
	
	
	public void enterFirstName() {
		wait.until(ExpectedConditions.visibilityOf(firstNameInput));
		firstNameInput.sendKeys("Tom");
	}

	public void enterLastName() {
		wait.until(ExpectedConditions.visibilityOf(lastNameInput));
		lastNameInput.sendKeys("Steve");
	}

	public void enterEmailInput() {
		wait.until(ExpectedConditions.visibilityOf(emailInput));
		emailInput.sendKeys("stevetom2@email.com");
	}

	public void enterNumberInput() {
		wait.until(ExpectedConditions.visibilityOf(numberInput));
		numberInput.sendKeys("9876543210");
	}

	public void enterPasswordInput() {
		wait.until(ExpectedConditions.visibilityOf(passwordInput));
		passwordInput.sendKeys("Tomsteve1");
	}

	public void enterPasswordConfirmInput() {
		wait.until(ExpectedConditions.visibilityOf(passwordConfirmInput));
		passwordConfirmInput.sendKeys("Tomsteve1");
	}

	public void clickCheckbox() {
		wait.until(ExpectedConditions.elementToBeClickable(privacyCheckbox));
		privacyCheckbox.click();
	}

	
	public RegisterAccount clickcontinueButton() {
		wait.until(ExpectedConditions.elementToBeClickable(continueButton));
		continueButton.click();
		return new RegisterAccount();
	}
	
	public RegisterAccount checkRegistration() {
		enterFirstName();
		enterLastName();
		enterEmailInput();
		enterNumberInput();
		enterPasswordInput();
		enterPasswordConfirmInput();
		clickCheckbox();
		return clickcontinueButton();
	}
	
	public String getTextMsg() {
		wait.until(ExpectedConditions.visibilityOf(getMessageText));
		return getMessageText.getText();	
	}

}
