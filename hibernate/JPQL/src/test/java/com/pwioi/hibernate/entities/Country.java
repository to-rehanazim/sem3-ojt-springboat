package com.pwioi.hibernate.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table

public class Country {
	
	@Id
	@GeneratedValue
	private int countryId;
	private String name;
	private long population;
	@OneToMany (mappedBy = "country")
	private List<State> states;
	
	
	public Country() {
		
	}
	public Country(int countryId, String name, long population) {
		super();
		this.countryId = countryId;
		this.name = name;
		this.population = population;
	}
	
	
	

	public List<State> getStates() {
		return states;
	}
	public void setStates(List<State> states) {
		this.states = states;
	}
	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", name=" + name + ", population=" + population + "]";
	}
}
