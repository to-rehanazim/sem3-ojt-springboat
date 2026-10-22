package com.pwioi.hibernate.entities;

import jakarta.persistence.*;

@Entity
@Table

public class Product {
	
	@Id
	private int id;
	private String name;
	private String brand;
	private float price;
	
	
	public int getId() {
		return id;
	}
	
	
	@Override
	public String toString() {
		return "Product [Id=" + id + ", name=" + name + ", brand=" + brand + ", price=" + price + "]";
	}


	public void setId(int id) {
		id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
	
	

}