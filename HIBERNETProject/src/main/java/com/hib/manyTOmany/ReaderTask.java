package com.hib.manyTOmany;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hib.cdac.HibernateUtil;

public class ReaderTask {

	public static void addRecord() {
		Session session=HibernateUtil.getSession();
		Transaction t=session.beginTransaction();
		
		Subscription s1=new Subscription();
		s1.setSname("Live Action MOvies");
		
		Subscription s2=new Subscription();
		s2.setSname("Live Sports");
		
		Subscription s3=new Subscription();
		s3.setSname("Web Series");
		
		Reader r1=new Reader();
		r1.setName("sudarshan");
		r1.setEmail("sudarshan@gmail.com");
		
		Reader r2=new Reader();
		r2.setName("rohit");
		r2.setEmail("rohit@gmail.com");
		
		Reader r3=new Reader();
		r3.setName("shubham");
		r3.setEmail("shubham@gmail.com");
		
		Reader r4=new Reader();
		r4.setName("rishi");
		r4.setEmail("rishi@gmail.com");
		
		Set<Subscription> ss=new HashSet<Subscription>();
		ss.add(s1);
		ss.add(s2);
		ss.add(s3);
		
		Set<Reader> rr=new HashSet<Reader>();
		rr.add(r1);
		rr.add(r2);
		rr.add(r3);
		rr.add(r4);
		
		r1.setSubscriptions(ss);
		r2.setSubscriptions(ss);
		r3.setSubscriptions(ss);
		r4.setSubscriptions(ss);
		
		session.save(r1);
		session.save(r2);
		session.save(r3);
		session.save(r4);
		
		session.save(s1);
		session.save(s2);
		session.save(s3);
		
		t.commit();
	}
	
	
	public static void showRecord() {
		
		  Session session=HibernateUtil.getSession();
		    Transaction t=session.beginTransaction();
	         org.hibernate.query.Query q=session.createQuery("from Subscription");
	         List<Subscription> sub=q.list();
	        
	         org.hibernate.query.Query q1=session.createQuery("from Reader");
	         List<Reader> red=q1.list();
	       
	         
	         for(Subscription s:sub)
	 	    {     Set <Reader> rd=s.getReaders();
	        	
	        	 
	        	
	        	 for(Reader r:rd)
	        	 {
	        	System.out.println( s.getSname()+" "+r.getName()+" "+r.getEmail());	        		 
	        		
	        		 
	        		
	        		  
	        		 
	        	 }
	        	 
	 	    }
	}
	public static void main(String[] args) {
		
//		addRecord();
		showRecord();

	}

}
