package com.hib.oneTOone;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hib.cdac.Employee;
import com.hib.cdac.HibernateUtil;

public class PersonTask {

	public static void addRecord() {
		Session session=HibernateUtil.getSession();
		Transaction t=session.beginTransaction();
		
		Scanner sc=new Scanner(System.in);
		
		Person p=new Person();
		System.out.println("Enter person name:");
		String pname=sc.nextLine();
		
		System.out.println("Enter person age:");
		int age=Integer.parseInt(sc.nextLine());
		
		Department d=new Department();
		System.out.println("Enter Department name:");
		String department=sc.nextLine();
		d.setDname(department);
		session.save(d);
		
		p.setAge(age);
		p.setPname(pname);
		
		p.setDepartment(d);
		session.save(p);
		t.commit();
		
				
	}
	
	public static void showPersonData() {
		Session session=HibernateUtil.getSession();
		Transaction t=session.beginTransaction();
		
		Query q=session.createQuery("from Person");
		List<Person> p=q.list();
		
		for (Person person : p) {
			System.out.println("pId:"+person.getPid()+"  Pname:"+person.getPname()+"  age:"+person.getAge()+""
					+ "   department:"+person.getDepartment().getDname());//first is from person and second is from department
		}
	}
	public static void main(String[] args) {
		
//		addRecord();
		showPersonData();

	}

}
