package pack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Parse_JSON {

	
	
	
	public JSONArray ParseJsonData(String inputLine) {
		List<GsonData> mylist = new ArrayList<GsonData>(); 
		JSONArray j1 = null;
		String title = "", date = "", cat = "", pub = "", cont = "", dis = "", more = "", auth = "", img = "";
		try {
			JSONParser parse = new JSONParser();
			JSONObject jobj = (JSONObject) parse.parse(inputLine);
			j1 = (JSONArray) jobj.get("items");
			for (int i = 0; i < j1.size();i++) {
				JSONObject json1 = (JSONObject) j1.get(i);
				JSONObject json2 = (JSONObject) json1.get("volumeInfo");
				title = (String) json2.get("title");
				JSONArray j3 = (JSONArray) json2.get("authors");
				auth = (String) j3.get(0);
				pub = (String) json2.get("publisher");
				dis = (String) json2.get("description");
				date = (String) json2.get("publishedDate");
				JSONObject json3 = (JSONObject) json1.get("saleInfo");
				cont = (String) json3.get("country");

				JSONArray j4 = (JSONArray) json2.get("categories");
				cat = (String) j4.get(0);

				more = (String) json2.get("infoLink");

				JSONObject json5 = (JSONObject) json2.get("imageLinks");
				img = (String) json5.get("thumbnail");
				
				mylist.add(new GsonData(title, auth, pub, date, cat, cont, dis, more, img));
				
				
			}
		

		} catch (Exception E) {
			System.out.println(E);
		}
		
		return j1;

	}

}