package com.pwioi.hibernate.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class State {
 @Id
 @GeneratedValue
 private int code;
 private String name;
 
 @ManyToOne(cascade = CascadeType.ALL)
 private Country country;
 
 public State() {
	 
 }

 public State(int code, String name) {
	super();
	this.code = code;
	this.name = name;
 }
 

 public Country getCountry() {
	return country;
}

 public void setCountry(Country country) {
	this.country = country;
 }

 public int getCode() {
	return code;
 }

 public void setCode(int code) {
	this.code = code;
 }

 public String getName() {
	return name;
 }

 public void setName(String name) {
	this.name = name;
 }
 
}
