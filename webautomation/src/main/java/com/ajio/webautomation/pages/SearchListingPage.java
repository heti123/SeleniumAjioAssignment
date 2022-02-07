package com.ajio.webautomation.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchListingPage extends BasePage{

	private By listingResults = new By.ByXPath("//div[contains(@class,'rilrtl-products-list')]");
	
	@FindBy(className="header2")
	private WebElement header;
	
	@FindBy(className="nameCls")
	private List<WebElement> itemNameList;
	
	@FindBy(className="offer-pricess")
	private List<WebElement> disPriceList;
	
	@FindBy(className="orginal-price")
	private List<WebElement> origPriceList;

	public SearchListingPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		waitForWebElement(listingResults, LONG_WAIT);
		System.out.println("Navigating to Search Listing Page.");
	}
	
	public boolean isHeaderName() {
		return header.isDisplayed();
	}

	public List<String> getItemNameDetails(){
		List<String> itemNameDetails = new ArrayList<>();
		//itemNameList.forEach(nameWebElement->itemNameDetails.add(nameWebElement.getText()));
		for(int i=0;i<6;i++) {
			String itemName=itemNameList.get(i).getText();
			itemNameDetails.add(itemName);
		}
		return itemNameDetails;
	}
	
	public List<String> getOrigPriceDetails(){
		List<String> origPriceDetails = new ArrayList<>();

		for(int i=0;i<6;i++) {
			String origPrice=origPriceList.get(i).getText();
			origPriceDetails.add(origPrice);
		}
		return origPriceDetails;
	}
	
	public List<String> getDiscPriceDetails(){
		List<String> discPriceDetails = new ArrayList<>();
		//itemNameList.forEach(nameWebElement->itemNameDetails.add(nameWebElement.getText()));
		for(int i=0;i<6;i++) {
			String discPrice=disPriceList.get(i).getText();
			discPriceDetails.add(discPrice);
		}
		return discPriceDetails;
	}

}
