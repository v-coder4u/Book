package pack;
import java.io.IOException;
import java.sql.*;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

//import com.sun.org.apache.regexp.internal.recompile;

import java.util.*;

import javax.security.sasl.SaslException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pack.Get_books;
import pack.GsonData;

public class DbConnection {

	private static String title;
	private static String date;
	private static String cat;
	private static String pub;
	private static String cont;
	private static String auth;

	private static String img, more, dis;


	static private SessionFactory sessionFactory = null;

	private static SessionFactory createSessionFactory() {
		if (sessionFactory == null) {
			sessionFactory = new Configuration().configure().addAnnotatedClass(GsonData.class).buildSessionFactory();

		}
		return sessionFactory;
	}

	private static void close_connection(Session s)
	{
		s.getTransaction().commit();
		
		s.close();
		//s.getSessionFactory().close();;
		System.out.println("connection closed");
	}
	
	
	public void saveDb(GsonData gd) {
		if (sessionFactory == null) {
			sessionFactory = createSessionFactory();
		}
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.save(gd);
		s.getTransaction().commit();
		s.close();
		
		
	}
	
	
	
static public List<?> getDb(String type,String text) throws SaslException, IOException, ServletException {
		if (sessionFactory == null) {
			sessionFactory = createSessionFactory();
		}
		
		Session s = sessionFactory.openSession();
		s.beginTransaction();


	if(type.equals("0"))
	{
	
	
		
	System.out.println("type ="+type);
		
		String hql = "select distinct(t) FROM GsonData t WHERE t.auth = '"+text+"'";
		Query<?> query = s.createQuery(hql);
		System.out.println(query);
		List<?> r0 = query.list();
		System.out.println(r0);
		close_connection(s);
		return r0;
		
	}
	
	
	else if(type.equals("1"))
	{
		
		//Pub_filter fr=new Pub_filter();
		//fr.parse_json(type,text);

		String hql = "select distinct(t) FROM GsonData t WHERE t.pub = '"+text+"'";
			Query<?> query = s.createQuery(hql);
			System.out.println(query);
			List<?> r1 = query.list();
			close_connection(s);
			return r1;
		
		
	}
	else
	{

		
		String hql = "select distinct(g) FROM GsonData g WHERE g.cat = '"+text+"'";
		
			Query<?> query = s.createQuery(hql);
			System.out.println(query);
			List<?> r2 = query.list();
			close_connection(s);
			return r2;
		
		
	}
	

	}


}
