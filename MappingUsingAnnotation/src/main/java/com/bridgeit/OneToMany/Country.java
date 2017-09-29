package com.bridgeit.OneToMany;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table (name="country_table")
public class Country implements Serializable {

	@Id
	@GenericGenerator (name="gen",strategy="increment")
	@GeneratedValue (generator="gen")
	private int seNum;
	
	@Column (name="country_name")
	private String name;
	
	@Column (name="population")
	private int population;
	
	@OneToMany (cascade=CascadeType.ALL)
	@JoinColumn (name="state_country")
	private Collection<States> states;
	
	
	
	
	public Collection<States> getStates() {
		return states;
	}

	public void setStates(Collection<States> states) {
		this.states = states;
	}

	public Country() {
		// TODO Auto-generated constructor stub
	}

	public int getSeNum() {
		return seNum;
	}

	public void setSeNum(int seNum) {
		this.seNum = seNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}
	
	
	
}
