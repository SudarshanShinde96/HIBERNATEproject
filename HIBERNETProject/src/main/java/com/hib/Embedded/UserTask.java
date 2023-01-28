package com.hib.Embedded;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hib.cdac.HibernateUtil;

public class UserTask {

	public static void addRecord() {
		Session session=HibernateUtil.getSession();
		Transaction t=session.beginTransaction();
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter name:");
		String name=sc.nextLine();
		System.out.println("Enter house number:");
		String hn=sc.nextLine();
		System.out.println("Enter city:");
		String city=sc.nextLine();
		System.out.println("Enter state:");
		String state=sc.nextLine();
		System.out.println("Enter country:");
		String country=sc.nextLine();
		System.out.println("Enter street:");
		String street=sc.nextLine();
		System.out.println("Enter pincode:");
		int pincode=Integer.parseInt(sc.nextLine());
		
		Address address=new Address();
		address.setHouse_no(hn);
		address.setCity(city);
		address.setState(state);
		address.setCountry(country);
		address.setStreet(street);
		address.setPincode(pincode);
		
		User user=new User();
		user.setName(name);
		user.setAddress(address);
		
		session.save(user);
		t.commit();
	}
	
	public static void updateRecord() {
		Session session=HibernateUtil.getSession();
		Transaction t=session.beginTransaction();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter user ID");
		int id=sc.nextInt();
		Query q=session.createQuery("from User where uid=:id");
		q.setParameter("id", id);
		List<User> list=q.list();
		User u=list.get(0);
		
		u.getAddress().setCity("pune");
		u.getAddress().setState("maharashtra");
		
		session.saveOrUpdate(u);
		t.commit();
	}
	
	public static void showAll() {
		Session session=HibernateUtil.getSession();
		Transaction t=session.beginTransaction();
		
		List<User> list=session.getNamedNativeQuery("All_user").list();
		
		for (User user : list) {
			    System.out.println(user.getName()+"  "+user.getAddress().getCity()+"   "+user.getAddress().getState());
		}
	}
	public static void main(String[] args) {
		
//		addRecord();
//		updateRecord();
		showAll();
		

	}

}
