package pack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.security.sasl.SaslException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Filter_search extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<GsonData> list = new ArrayList<>();


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws SaslException, IOException, ServletException {

		String date = "", cat = "", pub = "", cont = "", dis = "", more = "", img = "";
		String auth = "", title = "", order = "", type = "", text = "";

		DbConnection db = new DbConnection();

		List<GsonData> mylist = new ArrayList<GsonData>();

		type = request.getParameter("searchby");
		text = request.getParameter("search");
		order = request.getParameter("order");

		text = text.replace(" ", "%20");
		String p_url = response(type, text, order);
     
		System.out.println(p_url);

		Parse_JSON obj = new Parse_JSON();
		obj.ParseJsonData(p_url);

		Parse_JSON json = new Parse_JSON();
		JSONArray jarr = (JSONArray) json.ParseJsonData(p_url); // parse json
		try {
			for (int i = 0; i < jarr.size(); i++) {
				JSONObject json1 = (JSONObject) jarr.get(i);
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
				db.saveDb(new GsonData(title, auth, pub, date, cat, cont, dis, more, img));

			}

		} catch (Exception e) {
			System.out.println(e);

		}

		text = text.replace("%20", " ");

		// get list from database

		List<?> listdb = DbConnection.getDb(type, text);

		request.setAttribute("list", listdb);

		request.getRequestDispatcher("/FilterRes.jsp").forward(request, response);

	}

	public static String response(String a, String b, String c) { // Get Response in parameter and return the input url

		String type = "", res = "", order = "";
		String url = "https://www.googleapis.com/books/v1/volumes?q=";
		if (a == "0") {
			System.out.println(b);
			type = "authors=";
			if (c == "0" || c == "1") {
				order = "newest";

			} else {
				order = "relevance";
			}
			res = type + b + "&orderBy=" + order;
			System.out.println(res);
		} else if (a == "1") {
			type = "publisher=";
			if (c == "0" || c == "1") {
				order = "newest";

			} else {
				order = "relevance";
			}
			res = type + b + "&orderBy=" + order;
			System.out.println(res);
		} else {
			type = "title=";
			if (c == "0" || c == "1") {
				order = "newest";

			} else {
				order = "relevance";
			}
			res = type + b + "&orderBy=" + order;
		}

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
