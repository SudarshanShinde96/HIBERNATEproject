package com.hib.Embedded;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

@Entity
@NamedNativeQueries({@NamedNativeQuery(name = "All_user",
                     query = "select * from User",resultClass = User.class)})//optional for Query
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    private String name;
    
    @Embedded
    private Address address;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
    
    
}
