package com.hib.cdac;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static Session session;
	
	static {
		Configuration cfg=new Configuration();
		cfg.configure();
		sessionFactory =cfg.buildSessionFactory();
		session=sessionFactory.openSession();
	}

	public static Session getSession(){
		return session;		
	}
	public static void main(String []args) {
		System.out.println(session);
	}

}
