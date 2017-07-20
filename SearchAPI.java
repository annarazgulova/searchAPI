package interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class SearchAPI {
	    
	private HttpURLConnection conn = null;
	SearchAPI(String term, String country, String media, String limit ) throws Exception{
		if(conn ==null)
			conn = getConnectionConnected( term, country,  media, limit );
	}	
	
	public  int getHTTPrequestStatusCode()  {
		int res = -1;
		try {
			res= conn.getResponseCode();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return res;
	}
	 
	private HttpURLConnection  getConnectionConnected(String term, String country, String media, String limit ) {
		    HttpURLConnection conn = null;			
			URL url;
			try {
				url = new URL("https://itunes.apple.com/search?term=" + term + "&country" + country + "&media" + media + "&limit" + limit);
				conn = (HttpURLConnection) url.openConnection();
				conn.setRequestProperty("Accept", "application/json");
				conn.setRequestMethod("GET");
				conn.setDoInput(true);
				conn.setDoOutput(true);	
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   return conn;	
	 }
	 
	 public String getResponce(){
		BufferedReader br;
		String res ="";
		try {
			br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
				String output = "";				
				while ((output = br.readLine()) != null) {
					res = res+output;
				}		
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	 }
	 ////TODO
	 private void closeConnection() {
		conn.disconnect();
	 }
}
