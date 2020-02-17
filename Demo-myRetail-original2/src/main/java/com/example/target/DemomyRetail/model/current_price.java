package com.example.target.DemomyRetail.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class current_price {
	
	double value;
	String currency_code;
	
	public current_price(double value, String currency_code) {
		
		this.value= value;
		this.currency_code = currency_code;
	}

	public current_price() {
	
		this.value= 0.0;
		this.currency_code = "";
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getCurrency_code() {
		return currency_code;
	}

	public void setCurrency_code(String currency_code) {
		this.currency_code = currency_code;
	}
	
	public String toString() {
		return "value" + value +  "currency_code" + currency_code;
	
	}

}
