package com.example.target.DemomyRetail.service;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import javax.management.loading.PrivateClassLoader;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jca.cci.CannotCreateRecordException;
import org.springframework.stereotype.Service;

import com.example.target.DemomyRetail.model.Product;
import com.example.target.DemomyRetail.Exceptions.ProductCustomExceptions;
import com.example.target.DemomyRetail.Repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import com.mongodb.client.model.ReturnDocument;

@Service 
public class ProductService {

	

	@Autowired 
	private ProductRepository productRepository; 
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public ProductService() {
				
	}

	public Product getProductByid(int id) {
		Product product;
		product =  productRepository.findByid(id);
		
		
		String productDesc = new ExtApiCall().getProductInfoFromExtApi(id, "title");
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
					
		return product;
		}
	
	public Product updatePriceById(int productId, Product product) {
		
			Product oldProduct = productRepository.findByid(productId);
				
			oldProduct.setPrice(product.getPrice());
			
			productRepository.save(oldProduct);
			
			return oldProduct;
		}
	
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	// Delete operations
	public void deleteAll() {
		productRepository.deleteAll();
		return;
	}
}
