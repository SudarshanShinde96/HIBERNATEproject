package com.hib.cdac;

import java.util.Iterator;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import antlr.collections.List;

public class EmployeeTask {
	
	    static void addRecord() {
	    	Session session =HibernateUtil.getSession();
			Transaction t=session.beginTransaction();
			
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter your Name:");
			String name=sc.nextLine();
			
			System.out.println("Enter your address:");
			String address=sc.nextLine();
			
			System.out.println("Enter your mobile:");
			String mobile=sc.nextLine();
			
			Employee e=new Employee();
			
			e.setEmpname(name);
			e.setEmpaddress(address);
			e.setEmpmobile(mobile);
			
			session.save(e);
			t.commit();
			System.out.println("Detailes Saved");
	    }
	    
	    //show all record
	    
	     static void showEmployeeDetails() {
	    	 Session session =HibernateUtil.getSession();
			Transaction t=session.beginTransaction();
			
			Query q=session.createQuery("from Employee");
		    java.util.List<Employee> emp=q.list();
		    
		    for (Employee e : emp) {
				System.out.println("ID: "+e.getId()+"  name: "+e.getEmpname()+"   Address:"+e.getEmpaddress()+"   Mobile"+e.getEmpmobile());
				
			}
		    t.commit();
	     }
	     
	     //delete the record by id
	     static void deleteEmployeeById() {
	    	 Session session =HibernateUtil.getSession();
				Transaction t=session.beginTransaction();
				
				System.out.println("Enter Employee Id you want delete");
				Scanner sc=new Scanner(System.in);
				int eid=sc.nextInt();
						
				Query q=session.createQuery("from Employee where id=:id");
				q.setParameter("id", eid);
			    java.util.List<Employee> emp=q.list();
			    
			    if(emp.size()>0) {
			    	Employee e=emp.get(0);
			    	session.delete(e);
			    }
			    else {
					System.out.println("No Data Found");
				}
			    t.commit();
	     }
	     
	     //search employee by id
	     static void searchEmployeeById() {
	    	 Session session =HibernateUtil.getSession();
				Transaction t=session.beginTransaction();
				
				System.out.println("Enter Employee ID You Want Search");
				Scanner sc=new Scanner(System.in);
				int eid=sc.nextInt();
						
				Query q=session.createQuery("from Employee where id=:id");
				q.setParameter("id", eid);
				java.util.List<Employee> emp=q.list();
				if(emp.size()>0) {
			    	
			    	for (Employee e : emp) {
						System.out.println("ID: "+e.getId()+"  name: "+e.getEmpname()+"   Address:"+e.getEmpaddress()+"   Mobile"+e.getEmpmobile());
						
					}
			    }
			    else {
					System.out.println("No Data Found");
				}
			    t.commit();
	     }
	     
	     static void searchEmployeeByCriteria() {
	    	 Session session =HibernateUtil.getSession();
				Transaction t=session.beginTransaction();
				
				Criteria criteria=session.createCriteria(Employee.class);
				//criteria.add(Restrictions.like("name", "%a%"));
				//criteria.add(Restrictions.like("name", "%n"));
				//criteria.add(Restrictions.eq("name", "sudarshan"));
				//criteria.add(Restrictions.ne("name", "sudarshan"));
				criteria.setMaxResults(3);
				
				java.util.List<Employee> emp=criteria.list();
				
				for (Employee e : emp) {
					System.out.println("ID: "+e.getId()+"  name: "+e.getEmpname()+"   Address:"+e.getEmpaddress()+"   Mobile"+e.getEmpmobile());
					
				}
				t.commit();
	     }
	     
	     static void updateEmplyeeById() {
	 		
	 		Session session=HibernateUtil.getSession();
	 		Transaction t=session.beginTransaction();
	 		Scanner sc=new Scanner(System.in);
	 		System.out.println("Enter id to update");
	 		int eid=Integer.parseInt(sc.nextLine());
	 		
	 		System.out.println("Enter new name ");
	 		String name=sc.nextLine();
	 		System.out.println("Enter new mobile ");
	 		String mobile=sc.nextLine();
	 		System.out.println("Enter new Address ");
	 		String address=sc.nextLine();
	 		
	 		Query q=session.createQuery("from Employee e where e.id=:id");
	 		q.setParameter("id", eid);
	 		
	 		java.util.List<Employee> ls=q.list();
	 		
	          if (ls.size()>0) {
	 			
	 			Employee e=ls.get(0);
	 			e.setEmpaddress(address);
	 			e.setEmpmobile(mobile);
	 			e.setEmpname(name);
	 			session.update(e);
	 			
	 		} else {
	          System.out.println("Data not found |||");
	 		}
	 		
	 		t.commit();
	 		
	 		
	 	}

		public static void main(String[] args) {
			
			while(true) {
				System.out.println("Enter 1 for addRecord of Employee");
				System.out.println("Enter 2 for show all record Employee");
				System.out.println("Enter 3 for delete Employee");
				System.out.println("Enter 4 for search Employee by id");
				System.out.println("Enter 5 for search Employee by Criteria");
				System.out.println("Enter 6 for update Employee Information");
				System.out.println("Enter 7 for Exit");
				
				Scanner sc=new Scanner(System.in);
				int ch=sc.nextInt();
				
				switch (ch) {
				case 1:
					addRecord();
					break;
                case 2:
					showEmployeeDetails();
					break;
                case 3:
	                deleteEmployeeById();
                	break;
                case 4:
	               searchEmployeeById();
                	break;
                case 5:
	                searchEmployeeByCriteria();
                	break;
                case 6:
                	updateEmplyeeById();
                	break;
                case 7:
	                   System.exit(0);
                	break;
	

				default:
					break;
				}
			}
	}

}
