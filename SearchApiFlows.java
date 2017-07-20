package interview;

public class SearchApiFlows {
	 
	public static boolean verifyResponceCode(String term, String country,String media, String limit, int responceCodeExpected){
		boolean res = false;
		try {
			SearchAPI sa  = new SearchAPI(term, country, media, limit);
			res = (sa.getHTTPrequestStatusCode() == responceCodeExpected) ;
		} catch (Exception e) {
			//TODO: throws myCustom Exception which handle connection exceptions.
			e.printStackTrace();
		}
		return res;
	}
	
	public static boolean verifyResponceContent(String term, String country,String media, String limit, String patternExpected){
		boolean res = false;
		try {
			SearchAPI sa  = new SearchAPI(term, country, media, limit);
			res = (sa.getResponce().contains(patternExpected)) ;
		} catch (Exception e) {
			//TODO: throws myCustom Exception which handle connection exceptions.
			e.printStackTrace();
		}
		return res;
	}
}
