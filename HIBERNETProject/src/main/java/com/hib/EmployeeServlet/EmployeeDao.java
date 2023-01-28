package com.hib.EmployeeServlet;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hib.cdac.Employee;
import com.hib.cdac.HibernateUtil;

public class EmployeeDao {

	public static List<Employee> getEmployee(){ 
		Session session=HibernateUtil.getSession();
		Transaction t=session.beginTransaction();
		
		Query q=session.createQuery("from Employee");
	    java.util.List<Employee> emp=q.list();
	    t.commit();
	    
	    return emp;
	}
}
