package com.bridgeit.Pooja;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table (name="bridge_labz")
public class Bridgeit {
	
	@Id
	@GenericGenerator (name="big",strategy="increment")
	@GeneratedValue (generator="big")
	private int sNo;
	
	@Column (name="bri_emp")
	private int emp;
	
	@Column (name="bri_location")
	private String location;

	
	public int getsNo() {
		return sNo;
	}

	public void setsNo(int sNo) {
		this.sNo = sNo;
	}

	public int getEmp() {
		return emp;
	}

	public void setEmp(int emp) {
		this.emp = emp;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public Bridgeit() {
		
	}
	
}
