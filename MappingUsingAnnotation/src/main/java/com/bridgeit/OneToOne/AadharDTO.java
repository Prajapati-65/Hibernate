package com.bridgeit.OneToOne;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "aadhar_table")
public class AadharDTO implements Serializable {
	
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue (generator="gen")
	private int aadharNum;
	
	@Column (name="aadher_address")
	private String address;

	public int getAadharNum() {
		return aadharNum;
	}

	public void setAadharNum(int aadharNum) {
		this.aadharNum = aadharNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public AadharDTO() {
		// TODO Auto-generated constructor stub
	}
}
