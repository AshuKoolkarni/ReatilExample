package com.example.target.DemomyRetail.model;

import java.util.HashMap;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {
	@Id
	int id; 
	String name;
	current_price current_price;

	
		
	public current_price getPrice() {
		return current_price;
	}

	public void setPrice(current_price current_price) {
		this.current_price = current_price;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	

	

	public Product(int id, String name, current_price  current_price) {
		
		this.id = id;
		this.current_price = current_price;
		this.name = name;
		
	}
	
	public Product() {
		
		this.id = 0;
		this.current_price = new current_price();
		this.name = "";
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	
	public String toString() {
		return "id" + id +  "name" + name + "current_price" + current_price;
	
	}
	
	
}
