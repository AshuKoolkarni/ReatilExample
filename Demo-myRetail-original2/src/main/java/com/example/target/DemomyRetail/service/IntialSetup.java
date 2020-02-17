package com.example.target.DemomyRetail.service;

import com.example.target.DemomyRetail.model.current_price;
import com.example.target.DemomyRetail.model.Product;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.target.DemomyRetail.Exceptions.ProductCustomExceptions;
import com.example.target.DemomyRetail.Repository.ProductRepository;

@Service
public class IntialSetup {
	@Autowired 
	private ProductRepository productRepository; 
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * Populate data after initialize the application.
	 */
	@PostConstruct
	public void init() {
		setDB();
				
	}
	
	public IntialSetup() {
		
	}
	
	public void setDB() {
		// TODO Auto-generated constructor stub
		
				
		int idArray[] = {15117729, 16483589, 16696652, 16752456, 13860428};
		Product product ;
		current_price current_price;
		
		java.util.Map<String, Object> jsonMap;
		
			    
		for (int i = 0; i < idArray.length; i++) {
			
		    int productId = idArray[i];
			RestTemplate restTemplate = new RestTemplate(); 
			String response = "";
			boolean NoproductIdFound = false;
			
			
			
			current_price = new current_price(1.1 + i, "$ USD");
		    
		    product = productRepository.save(new Product(productId,"", current_price));
		    
		 	
		    String productDesc = new ExtApiCall().getProductInfoFromExtApi(productId, "title");
		    if (productDesc.equals(product.getname())) {
	     	}
	     		else {
	     			try {
				        	product.setname(productDesc);
				        	productRepository.save(product);
				     		} catch (Exception e) {
	     				throw new ProductCustomExceptions("Product Info not found on Api" );
					}
	     	}
		}
	}
}
