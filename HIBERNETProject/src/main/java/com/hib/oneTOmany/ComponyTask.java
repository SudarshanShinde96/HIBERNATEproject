package com.hib.oneTOmany;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hib.cdac.HibernateUtil;
import com.hib.oneTOone.Person;


public class ComponyTask {
public static void addrecord() {
	Session session=HibernateUtil.getSession();
	Transaction t=session.beginTransaction();
	Company c=new Company();
	c.setComponyName("Jio");
	Set<Customer> s=new HashSet<Customer>();
	
	Customer su=new Customer();
	su.setAddress("Mumbai");
	su.setName("Shinde");
	s.add(su);
	
	Customer rs=new Customer();
	rs.setAddress("Patna");
	rs.setName("Shubham");
	s.add(rs);
	
	Customer ro=new Customer();
	ro.setAddress("Lucknow");
	ro.setName("Sajid");
	s.add(ro);
	
	Customer r=new Customer();
	r.setAddress("Delhi");
	r.setName("Rishi");
	s.add(r);
	
	c.setCustomer(s);//add customer to company
	session.save(c);//save record
	t.commit();
}

  public static void showAllData() {
	  Session session=HibernateUtil.getSession();
		Transaction t=session.beginTransaction();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter Compony Id");
		Query q=session.createQuery("from Company");
		
		List<Company>companies=q.list();
	 
	 	for (Company company : companies) {
	        	Set<Customer> set=company.getCustomer();
	        	System.out.println("Compony id:"+company.getCompany_id());
	        	System.out.println("Compony id:"+company.getComponyName());
	        	
	        	for (Customer c :set) {
					System.out.println("customer id:"+c.getCid()+"   Customer name:"+c.getName()+"  Customer Address:  "+c.getAddress());
				}
		}
		
	}
  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		addrecord();
		showAllData();
	}

}