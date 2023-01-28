package com.hib.manyTOmany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="Reader" , 
       uniqueConstraints = {@UniqueConstraint(columnNames = "email"),
    		                @UniqueConstraint(columnNames = "reader")}
      )
public class Reader {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int reader;
private String name;
private String email;
@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE },fetch = FetchType.LAZY)
@JoinTable(name = "reader_subscription",
            joinColumns = {@JoinColumn(referencedColumnName = "reader")},
            inverseJoinColumns = {@JoinColumn(referencedColumnName = "subscriptionid")})
private Set<Subscription> subscriptions;
public int getReader() {
	return reader;
}
public void setReader(int reader) {
	this.reader = reader;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Set<Subscription> getSubscriptions() {
	return subscriptions;
}
public void setSubscriptions(Set<Subscription> subscriptions) {
	this.subscriptions = subscriptions;
}



}
