package com.bridgeit.OneToMany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table (name="state_table")
public class States {
	
	@Column (name="state_name")
	private String name;
	
	@Id
	@GenericGenerator (name="gen",strategy="increment")
	@GeneratedValue (generator="gen")
	private int no;
	
	@Column (name="capital")
	private String capital;
	

	public States() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}
	

	
}
