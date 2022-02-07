package com.ajio.webautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BasePage{

	@FindBy(className="ic-search")
	private WebElement searchBtn;

	@FindBy(name="searchVal")
	private WebElement searchAjio;

	public SearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		waitForWebElement(searchBtn, LONG_WAIT);
		System.out.println("Navigating to Search Page.");
	}

	public void enterCloth(String clothName) {
		searchAjio.sendKeys(clothName);
	}

	public SearchListingPage clickSearchBtn() {
		searchBtn.click();
		return new SearchListingPage(driver);
	}

}
