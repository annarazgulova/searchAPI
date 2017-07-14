package interview;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class SearchAPI {
	    
	 public static boolean doHTTPrequest(String term, String country, String media, String limit ) {
		Boolean res = false;
		try {
			URL url = new URL("https://itunes.apple.com/search?term=" + term + "&country" + country + "&media" + media + "&limit" + limit);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestMethod("GET");
			conn.setDoInput(true);
			conn.setDoOutput(true);			
		 
		    conn.connect();
			if (conn.getResponseCode() == 200) {
				 res=true;
			}
			/*use for debug:
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output = "";
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
			*/
			conn.disconnect();
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return res;
	}

}
