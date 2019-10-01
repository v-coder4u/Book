
package pack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class Pub_filter {

	

		
	public void parse_json(String type, String text) {
		// TODO Auto-generated method stub
		
		text = text.replace(" ", "%20");
		String p_url = response(type, text);
		
		
		
		
		
		
		
		
	}
		
		
		
	
		
		
		
		public static String response(String a, String b) { // Get Response in parameter and return the input url

			String type = "", res = "", order = "";
			String url = "https://www.googleapis.com/books/v1/volumes?q=";
		
				type = "publisher=";
				
				res = type + b;
				System.out.println(res);


			String query = url + res;
			System.out.println(query);
			String inputLine = "";
			try {
				URL obj = new URL(query);
				HttpURLConnection con = (HttpURLConnection) obj.openConnection();
				con.setRequestMethod("GET");
				con.setRequestProperty("User-agent", "chrome");
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

				StringBuffer response = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);

				}
				in.close();
				inputLine = response.toString();
			} catch (IOException E) {
				System.out.println(E);

			}
			return inputLine;

		}







		
		
		
		
		
		
		
		
		
		
		
		
	
}

	