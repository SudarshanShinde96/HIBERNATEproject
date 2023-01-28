package com.hib.oneTOone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Department {
	@Id
	@GeneratedValue
private int did;
private String dname; 

@OneToOne(mappedBy = "department")//mapped by department table (class)
private Person person;

public int getDid() {
	return did;
}

public void setDid(int did) {
	this.did = did;
}

public String getDname() {
	return dname;
}

public void setDname(String dname) {
	this.dname = dname;
}

public Person getPerson() {
	return person;
}

public void setPerson(Person person) {
	this.person = person;
}


}
