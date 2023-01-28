package com.hib.cdac;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {
@Id
@GeneratedValue
private int id;

@Column(name = "name" ,length = 100 ,nullable = false)
private String empname;

@Column(name = "address" ,length = 100 ,nullable = false)
private String empaddress;

@Column(name = "mobile" ,length = 15 ,nullable = false)
private String empmobile;



public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEmpname() {
	return empname;
}
public void setEmpname(String empname) {
	this.empname = empname;
}
public String getEmpaddress() {
	return empaddress;
}
public void setEmpaddress(String empaddress) {
	this.empaddress = empaddress;
}
public String getEmpmobile() {
	return empmobile;
}
public void setEmpmobile(String empmobile) {
	this.empmobile = empmobile;
}


}
