package pack;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.hibernate.criterion.SimpleExpression;

@Entity
public class GsonData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	public int getId() {
		return id;
	}

	private String title;
	private String date;
	private String cat;
	private String pub;
	private String cont;

	@Type(type = "text")
	private String dis;

	@Type(type = "text")
	private String more;
	private String auth;

	@Type(type = "text")
	private String img;
	private String price;
	private String page;
	

	public GsonData() {
		super();
	}



	public GsonData(String title, String auth, String pub, String date, String cat, String cont, String dis,
			String more, String img) {
		this.title = title;
		this.auth = auth;
		this.pub = pub;
		this.date = date;
		this.cat = cat;
		this.cont = cont;
		this.dis = dis;
		this.more = more;
		this.img = img;
	
	}

	
//---------------------------- Setters
	
	
	public void setTitle(String title) {
		this.title = title;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public void setPub(String pub) {
		this.pub = pub;
	}

	public void setCont(String cont) {
		this.cont = cont;
	}

	public void setDis(String dis) {
		this.dis = dis;
	}

	public void setMore(String more) {
		this.more = more;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
	
//------------------------------------------Getters
	
	
	public String getAuthorData() {
		return auth;
	}

	public String getTitleData() {
		return title;
	}

	public String getPubData() {
		return pub;
	}

	public String getDateData() {
		return date;
	}

	public String getCatData() {
		return cat;
	}

	public String getImgData() {
		return img;
	}

	public String getCountryData() {
		return cont;
	}

	public String getDescriptionData() {
		return dis;
	}

	public String getInfoData() {
		return more;
	}

	@Override
	public String toString() {
		return "GsonData [id=" + id + ", title=" + title + ", date=" + date + ", cat=" + cat + ", pub=" + pub
				+ ", cont=" + cont + ", dis=" + dis + ", more=" + more + ", auth=" + auth + ", img=" + img + ", price="
				+ price + ", page=" + page + "]";
	}

}
