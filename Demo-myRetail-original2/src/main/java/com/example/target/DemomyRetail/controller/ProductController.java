package com.example.target.DemomyRetail.controller;



import java.lang.reflect.Array;
import java.util.*;

import javax.management.loading.PrivateClassLoader;

import org.apache.naming.java.javaURLContextFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import javax.management.loading.PrivateClassLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.*;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.data.mongodb.core.aggregation.VariableOperators.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.target.DemomyRetail.service.ProductService;
import com.example.target.DemomyRetail.service.IntialSetup;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import springfox.documentation.spring.web.json.Json;

import com.example.target.DemomyRetail.Exceptions.ProductCustomExceptions;
import com.example.target.DemomyRetail.model.Product;


@RestController
public class ProductController {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductService productService; 
	
	
	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	public ResponseEntity<Product> getProductInfo(@PathVariable("id") int id) {
	
		// Delete it
	
		Product product = productService.getProductByid(id);
		
		
		return new ResponseEntity<Product>(product, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/products/{id}", method = RequestMethod.PUT, produces = "application/json")
	public Product updatePrice(@RequestBody Product product, @PathVariable("id") int productId) {
		
		try {
			productService.updatePriceById(productId, product);
			
		} catch (Exception ex) {
			logger.info("Product Not Found Exception ");
			throw new ProductCustomExceptions("Product Not Found Exception ");
			
		}
		return  product;
	}
	
	
	
}
