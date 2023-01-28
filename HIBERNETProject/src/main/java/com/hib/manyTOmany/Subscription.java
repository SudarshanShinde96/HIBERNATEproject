package com.hib.manyTOmany;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity

public class Subscription {
@Id
@GeneratedValue( strategy = GenerationType.AUTO)
private int subscriptionid;
private String sname;

@ManyToMany(mappedBy = "subscriptions",
             fetch = FetchType.LAZY) 
private Set<Reader> readers;

public int getSubscriptionid() {
	return subscriptionid;
}

public void setSubscriptionid(int subscriptionid) {
	this.subscriptionid = subscriptionid;
}

public String getSname() {
	return sname;
}

public void setSname(String sname) {
	this.sname = sname;
}

public Set<Reader> getReaders() {
	return readers;
}

public void setReaders(Set<Reader> readers) {
	this.readers = readers;
}

}
