package com.naveenautomationlabs.AutomationFramework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class Macbook extends TestBase {
	public Macbook() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(xpath = "//button[@id = 'button-cart']")
	private WebElement addToCartButton;

	@FindBy(css = "#product-product > div.alert.alert-success.alert-dismissible")
	private WebElement successBanner;

	public Macbook clickaddToCartButton() {
		wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
		addToCartButton.click();
		return new Macbook();
	}

	public String getSuccessMsg() {
		return successBanner.getText();
	}
}
