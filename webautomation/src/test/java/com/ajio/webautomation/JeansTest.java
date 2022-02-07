package com.ajio.webautomation;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ajio.webautomation.pages.SearchListingPage;
import com.ajio.webautomation.pages.SearchPage;

public class JeansTest extends TestBase{
	
	private SearchPage searchPage;
	private SearchListingPage searchListingPage;
	
	@Test(description="Verify jeans details for the first six jeans listed.")
	public void agentDetailsVerification() {
		
		//Searching for Jeans
		searchPage = new SearchPage(webdriver);
		searchPage.enterCloth("Jeans");
		searchListingPage = searchPage.clickSearchBtn();
		
		Assert.assertTrue(searchListingPage.isHeaderName(), "Jeans header is missing on the details page.");
		
		//Jeans details on the search listing screen
		List<String> jeansNames = searchListingPage.getItemNameDetails();
		System.out.println("Jeans names: "+jeansNames);
		
		List<String> jeansDiscPrice = searchListingPage.getDiscPriceDetails();
		System.out.println("Jeans Discounted Prices: "+jeansDiscPrice);
		
		List<String> jeansOrigPrice = searchListingPage.getOrigPriceDetails();
		System.out.println("Jeans Original Prices: "+jeansOrigPrice);
		String highOrigPrice=Collections.max(jeansOrigPrice);
		System.out.println("Jeans Highest Original Price: "+highOrigPrice);
		
		
		}

}
