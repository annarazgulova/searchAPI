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
 		SearchAPI.doHTTPrequest(term, country, media, limit);
  		Assert.assertTrue(SearchAPI.doHTTPrequest(term, country, media, limit));		 
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
}


