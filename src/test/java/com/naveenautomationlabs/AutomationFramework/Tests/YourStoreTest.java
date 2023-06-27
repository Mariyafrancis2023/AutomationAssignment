package com.naveenautomationlabs.AutomationFramework.Tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.AutomationFramework.Pages.RegisterAccount;
import com.naveenautomationlabs.AutomationFramework.Pages.Iphone;
import com.naveenautomationlabs.AutomationFramework.Pages.Macbook;
import com.naveenautomationlabs.AutomationFramework.Pages.SearchIphone;
import com.naveenautomationlabs.AutomationFramework.Pages.SearchMacbook;
import com.naveenautomationlabs.AutomationFramework.Pages.YourStore;
import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class YourStoreTest extends TestBase {

	private YourStore yourStore;
	private RegisterAccount register;
	private SearchIphone searchIphone;
	private Iphone iphone;
	private SearchMacbook searchMacbook;
	private Macbook macbook;

	@BeforeMethod
	public void setUp() {
		initialization();
		yourStore = new YourStore();
		searchIphone = new SearchIphone();
		iphone = new Iphone();
		searchMacbook = new SearchMacbook();
		macbook = new Macbook();
	}

	@Test
	public void validateIPhoneAddToCartSuccessfull() {
		yourStore.searchInput("iphone");
		iphone = searchIphone.clickProductLink();
		iphone.clickaddToCartButton();
		iphone.getSuccessMsg();
		Assert.assertEquals(iphone.getSuccessMsg(), "Success: You have added iPhone to your shopping cart!",
				"incorrect message");
	}

	@Test
	public void validateMacBookAddToCartSuccessfull() {
		yourStore.searchInput("macbook");
		macbook = searchMacbook.clickProductLink();
		macbook.clickaddToCartButton();
		macbook.getSuccessMsg();
		Assert.assertEquals(iphone.getSuccessMsg(), "Success: You have added MacBook to your shopping cart! ",
				"incorrect message");
	}

	@Test
	public void validateAddToWishList() {
		String initialWishListNumber = yourStore.getWishListNumber();
		yourStore.clickWishListBtn();
		waitUntilWishListNumberUpdates(initialWishListNumber);
		String updatedWishListNumber = yourStore.getWishListNumber();
		Assert.assertNotEquals(updatedWishListNumber, initialWishListNumber, "number did not changed");
	}

	public void waitUntilWishListNumberUpdates(String initialNumber) {
		int count = 0;
		while (count < 10) {
			if (!yourStore.getWishListNumber().equals(initialNumber)) {
				break;
			}
			count++;
		}
	}  

	@Test
	public void validateAddToCart() {
		yourStore.clickAddToCartBtn();
		yourStore.clickCartBtn();
		yourStore.clickViewCartBtn();
		Assert.assertEquals(wd.getTitle(), "Shopping Cart", "incorrect page");
	}

	@Test
	public void validateSlider() {
		yourStore.sliderSelection();
		Assert.assertEquals(wd.getTitle(), "Samsung Galaxy Tab 10.1", "incorrect page");
	}

	@AfterMethod
	public void quit() {
		tearDown();
	}
}
