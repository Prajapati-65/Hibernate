package com.bridgeit.OneToOne;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "person_table")
public class PersonDTO implements Serializable {

	@Column(name = "per_name")
	private String name;

	@Column(name = "per_location")
	private String location;

	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private int mobNum;

	@Column(name = "per_age")
	private int age;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn (name="aadhar_addr")
	private AadharDTO aadhar;

	public PersonDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getMobNum() {
		return mobNum;
	}

	public void setMobNum(int mobNum) {
		this.mobNum = mobNum;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public AadharDTO getAadhar() {
		return aadhar;
	}

	public void setAadhar(AadharDTO aadhar) {
		this.aadhar = aadhar;
	}

}
