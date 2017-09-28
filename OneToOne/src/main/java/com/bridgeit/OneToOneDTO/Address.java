package com.bridgeit.OneToOneDTO;

public class Address {

	private int sid;
	private String flatno, plotno, street, city;
	private Student student;

	public Address() {
		
	}

	public Address(String flatno, String plotno, String street, String city, Student student) {
		
		this.street = street;
		this.flatno = flatno;
		this.plotno = plotno;
		this.city = city;
		this.student = student;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getFlatno() {
		return flatno;
	}

	public void setFlatno(String flatno) {
		this.flatno = flatno;
	}

	public String getPlotno() {
		return plotno;
	}

	public void setPlotno(String plotno) {
		this.plotno = plotno;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Address [sid=" + sid + ", flatno=" + flatno + ", plotno=" + plotno + ", street=" + street + ", city="
				+ city + ", student=" + student + "]";
	}

	
}
