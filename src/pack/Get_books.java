package pack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Get_books extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ArrayList<GsonData> list = new ArrayList<>();

	protected void doPost(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {

		String date = "", cat = "", pub = "", cont = "", dis = "", more = "", img = "",title="",auth="";
		
		List<GsonData> mylist = new ArrayList<GsonData>();
		auth = request.getParameter("auth");
		title = request.getParameter("title"); 
		
		String auth1 = auth.replace(" ", "%20");
		String title1 = title.replace(" ", "%20");
		
		
		String p_url = response(auth1, title1); // Get JSON response with the help of parameter and get the parsed url
		
		DbConnection db = new DbConnection();
			
		Parse_JSON json = new Parse_JSON();
		
			
			JSONArray jarr = (JSONArray) json.ParseJsonData(p_url);
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
					
					
				}

			} catch (Exception e) {
				System.out.println(e);
			}
			
			

			
			db.saveDb(new GsonData(title, auth, pub, date, cat, cont, dis, more, img));
			request.setAttribute("list", mylist);
			request.getRequestDispatcher("/res.jsp").forward(request, res);

		}
	
	
	
	


	public String response(String a, String b) { // Get Response in parameter and return the input url

		String url = "https://www.googleapis.com/books/v1/volumes?q=";
		String query = url + "title=" + b + "&author=" + a;
		//System.out.println("qyery="+query);
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
		//System.out.println("inputline="+inputLine);
		return inputLine;
	}

}
