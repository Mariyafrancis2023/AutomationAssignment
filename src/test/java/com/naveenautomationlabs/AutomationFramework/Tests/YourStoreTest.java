package com.naveenautomationlabs.AutomationFramework.Tests;

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
	
	YourStore yourStore;
	RegisterAccount register;
	SearchIphone searchIphone; 
	Iphone iphone;
	SearchMacbook searchMacbook;
	Macbook macbook;
	
	

	@BeforeMethod
	public void setUp() {
		initialization();
		yourStore = new YourStore();
		searchIphone = new SearchIphone();
		iphone =  new Iphone();
		searchMacbook = new SearchMacbook();
		macbook = new Macbook();
	}
	
		@Test
		public void validateIPhoneAddToCartSuccessfull() {
			yourStore.searchInput("iphone");
			iphone = searchIphone.clickProductLink();
			iphone.clickaddToCartButton();
			iphone.getSuccessMsg();
			Assert.assertEquals(iphone.getSuccessMsg(), "Success: You have added iPhone to your shopping cart!");
		}
		
		@Test
		public void validateMacBookAddToCartSuccessfull() {
			yourStore.searchInput("macbook");
			macbook = searchMacbook.clickProductLink();
			macbook.clickaddToCartButton();
			macbook.getSuccessMsg();
			Assert.assertEquals(iphone.getSuccessMsg(), "Success: You have added MacBook to your shopping cart! ");
		}
		
		@Test
		public void validateMacBookAddToWishList() {
			yourStore.clickWishListBtn();
			Assert.assertEquals(yourStore.getWishListText(), "Wish List (1)");
		}
		
		@Test
		public void validateAddToCart() {
			yourStore.clickAddToCartBtn();
			yourStore.clickCartBtn();
			yourStore.clickViewCartBtn();
			Assert.assertEquals(wd.getTitle(), "Shopping Cart");
		}
			
		@Test
		public void validateSlider() {
			yourStore.sliderSelection();
			Assert.assertEquals(wd.getTitle(), "Samsung Galaxy Tab 10.1");
		}
			
		@AfterMethod
		public void quit() {
			tearDown();
		}
}
