package interview;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCasesSearchAPI {
	
 	/******* API  exercise **********/
 	/*
 	 * TEST PLAN:
 	    https://itunes.apple.com/search?parameterkeyvalue				
 			
 		1. Test for all combinations:
 		term	     country	    media	     limit		 							
 		<valid>	     <valid>	   <valid>	    <valid>	           extend  every <valid> for possible valid values
 		<nonvalid>	 <nonvalid>	   <nonvalid>	<nonvalid>	       extend every <invalid> for possible invalid values. Example: country: US3, U^S, R ussia,   
 		omitted		 omitted	    omitted	    omitted	
 		
 							
 		2. Other test:
 			http-hhtps				
 			browsers compatibility 				
 			platform compatibility				
 			stress: simulate big amount of requests per sec (Jmetter) 
   */
	
	
 	
 	@Test(dataProvider = "testItunesAPI", groups={"apiExercise"})
 	public void testItunesAPI(String term, String country, String media, String limit ) {
 		Assert.assertTrue(SearchApiFlows.verifyResponceCode(term, country, media, limit, 200));		 
 	}
 	@DataProvider(name = "testItunesAPI")
 	// just example here. I would implement buildTestMatrix class which build data objects according test plan dynamically.
 	public static Object[][] itunesApiParams() {
 		return new Object[][] {
 				{ "anna", "", "", ""},
 				{ "anna", "US", "movies", "20" },
 				{ "anna", "Russia", "movies", "0"},
 				 };
 	}
 	
 	@Test(dataProvider = "testItunesAPIcontent", groups={"apiExercise"})
 	public void testItunesAPIcontent(String term, String country, String media, String limit, String expectedPattern) {
 		Assert.assertTrue(SearchApiFlows.verifyResponceContent(term, country, media, limit,  expectedPattern));		 
 	}
 	@DataProvider(name = "testItunesAPIcontent")
 	public static Object[][] itunesApiParams1() {
 		return new Object[][] {
 				{ "anna", "", "", "", "anna"},
 				{ "anna", "US", "movies", "20", "Anna" },
 				{ "anna", "Russia", "movies", "0", "Russia"},
 				 };
 	}
}


