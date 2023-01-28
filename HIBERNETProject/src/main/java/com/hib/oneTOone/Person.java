package com.hib.oneTOone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Person")
public class Person {
@Id
@GeneratedValue
private int pid;
private String pname;
private int age;
@OneToOne
@JoinColumn(name = "Department_id")
private Department department;
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public Department getDepartment() {
	return department;
}
public void setDepartment(Department department) {
	this.department = department;
}


}
