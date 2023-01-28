package com.hib.oneTOmany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int company_id;
private String componyName;

@OneToMany(targetEntity = Customer.class,cascade = CascadeType.ALL)
@JoinColumn(name = "comp_id",referencedColumnName = "company_id")
private Set customer;

public int getCompany_id() {
	return company_id;
}

public void setCompany_id(int company_id) {
	this.company_id = company_id;
}

public String getComponyName() {
	return componyName;
}

public void setComponyName(String componyName) {
	this.componyName = componyName;
}

public Set getCustomer() {
	return customer;
}

public void setCustomer(Set customer) {
	this.customer = customer;
}



}
