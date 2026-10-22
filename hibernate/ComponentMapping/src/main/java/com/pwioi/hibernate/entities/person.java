package com.pwioi.hibernate.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class person {
	private static final GenerationType AUTO = null;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

  private int personId;
  private Name personName;
  private float age;
  
  public person() {
	  
  }

  public person(int personId, Name personName, float age) {
	super();
	this.personId = personId;
	this.personName = personName;
	this.age = age;
  }

  public int getPersonId() {
	return personId;
}

  public void setPersonId(int personId) {
	this.personId = personId;
  }

  public Name getPersonName() {
	return personName;
  }

  public void setPersonName(Name personName) {
	this.personName = personName;
  }

  public float getAge() {
	return age;
  }

  public void setAge(float age) {
	this.age = age;
  }

  public static GenerationType getAuto() {
	return AUTO;
  }

  @Override
  public String toString() {
	return "person [personId=" + personId + ", personName=" + personName + ", age=" + age + "]";
  }
  
}
