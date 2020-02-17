package com.example.target.DemomyRetail.Repository;
//import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.target.DemomyRetail.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String >{
	
		public Product findByid(int id);


}

