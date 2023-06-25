package com.naveenautomationlabs.AutomationFramework.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class YourStore extends TestBase {

	public YourStore() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "input[name='search']")
	WebElement searchInput;

	@FindBy(css = "span button[type='button']")
	WebElement searchButton;
	
	@FindBy(xpath = "(//button[@data-original-title='Add to Wish List'])[1]")
	WebElement wishListBtn;
	
	@FindBy(css = "#wishlist-total")
	WebElement wishListText;
	

	public void searchInput(String productName) {
		wait.until(ExpectedConditions.visibilityOf(searchInput));
		searchInput.sendKeys(productName);
	}

	public SearchIphone clickiphoneSearchBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(searchButton));
		searchButton.click();
		return new SearchIphone();
	}

	public SearchMacbook clickmacbookSearchBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(searchButton));
		searchButton.click();
		return new SearchMacbook();
	}
	
	public YourStore clickWishListBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(wishListBtn));
		wishListBtn.click();
		return new YourStore();
	}
	
	public String getWishListText() {
		return wishListText.getText();
	}

	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountLink;
	
	@FindBy(xpath = "//a[text()='Register']")
	private WebElement registerLink;
	
	@FindBy(xpath = "//a[text()='Login']")
	private WebElement loginLink;
	
	public void clickMyAccountLink() {
		myAccountLink.click();
	}
	
	public RegisterAccount clickRegisterLink() {
		registerLink.click();
		return new RegisterAccount();
	}

	public AccountLogin clickLoginLink() {
		loginLink.click();
		return new AccountLogin();
	}
	
	@FindBy (css = "div.product-layout div.caption a")
	List<WebElement> productsList;
	
	public String navigateProducts(String productName) {
		wait.until(ExpectedConditions.visibilityOfAllElements(productsList));
		for(int i = 0; i < productsList.size(); i++) {
			if(productsList.get(i).getText().equals(productName)) {
				productsList.get(i).click();
			}
		}
		return wd.getTitle();
	}
	
	@FindBy (xpath = "(//button[@data-original-title = \"Compare this Product\"])[2]")
	WebElement compareProductBtn;
	
	@FindBy (xpath = "//a[text() = 'product comparison']")
	WebElement compareProductLink;
	
	public void clickCompareProductBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(compareProductBtn));
		compareProductBtn.click();
	}
	
	public ProductComparison clickCompareProductLink() {
		wait.until(ExpectedConditions.visibilityOf(compareProductLink));
		compareProductLink.click();
		return new ProductComparison();
	}
	@FindBy(xpath = "//button[@onclick=\"cart.add('43');\"]")
	WebElement addToCartBtn;
	
	@FindBy(xpath = "//span[@id='cart-total']")
	WebElement cartBtn;
	
	@FindBy(xpath = "//*[@id=\"cart\"]/ul/li[2]/div/p/a[1]")
	WebElement viewCartBtn;
	
	public void clickAddToCartBtn() {
		wait.until(ExpectedConditions.visibilityOf(addToCartBtn));
		addToCartBtn.click();
	}

	public void clickCartBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(cartBtn));
		cartBtn.click();
	}
	
	public void clickViewCartBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(viewCartBtn));
		viewCartBtn.click();
	}
	
	@FindBy(xpath = "//div[contains(@class, 'swiper-container')]")
	WebElement slider;
	
	@FindBy(xpath = "//div[contains(@class, 'swiper-container')]/div[contains(@class, 'swiper-wrapper')]/div[contains(@class, 'swiper-slide')]")
	List<WebElement> sliderList;
	
	public void sliderSelection() {
		Actions actions = new Actions(wd);
		System.out.println(sliderList.size());
		for(int i = 0; i < sliderList.size(); i++) {
			actions.moveToElement(slider).perform();
			actions.clickAndHold().release().perform();
		}
	}
}

