package com.example.target.DemomyRetail.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.target.DemomyRetail.Exceptions.ProductCustomExceptions;
import com.example.target.DemomyRetail.Repository.ProductRepository;
import com.example.target.DemomyRetail.model.Product;

public class ExtApiCall {
	
	private ProductRepository productRepository; 
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public ExtApiCall() {
		// TODO Auto-generated constructor stub
	}
//	public  String getProductInfoFromExtApi(Product product, int productId, String findVal) {
	public  String getProductInfoFromExtApi(int productId, String findVal) {
		
		RestTemplate restTemplate = new RestTemplate(); 
		String response = "";
		boolean NoproductIdFound = false;
		String productDesc = "" ;
		try {   
	
			response = restTemplate.getForObject("https://redsky.target.com/v2/pdp/tcin/" +productId+ "?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics", String.class);
		} catch (RestClientException ex) {
				NoproductIdFound = true;
	
		}

		
		if (NoproductIdFound != true) {			
			JacksonJsonParser parser= (JacksonJsonParser) JsonParserFactory.getJsonParser();
			Map<String, Object> jsonMap = parser.parseMap(response);
			
			for(Object key:( jsonMap.keySet())){
		
				java.util.Map<String, Object> indexMap = getKeyValue(jsonMap,"product_id", Integer.toString(productId));
			
				if (indexMap != null) {
				
					logger.info("Index map    " + indexMap.toString());
					
					if(jsonMap.get(key) instanceof java.util.Map){
				           
						productDesc = getKeyValue2((Map<String, Object>) jsonMap.get(key), findVal);
				   //  	logger.info("Product Info before" + productDesc+ "******"+ product.toString() + product.getname());
				    
					}
				}
				else
					logger.info("Product not Found");
			}
		}
		return productDesc;
	}
	
	
private java.util.Map<String, Object> getKeyValue(java.util.Map<String, Object> jsonMap, String findKey, String findVal) {
	
	Object indexkey = null;
	java.util.Map<String, Object> indexMap;
	indexMap = jsonMap;
	for(Object key:( jsonMap.keySet())){
    	indexkey = key;
    //	logger.info("Keys of Json  " + findKey+ "!=" + key.toString()+"#");
        if(findKey.equals(key.toString()) && findVal.equals(jsonMap.get(indexkey).toString())){
        	 indexkey = key;
      	
        	 logger.info("product_id " + jsonMap.get(indexkey).toString());
        	 return indexMap;
        }else{

            if(jsonMap.get(key) instanceof java.util.Map){
           
                indexMap = getKeyValue((java.util.Map<String, Object>) jsonMap.get(key), findKey, findVal);
                if (indexMap != null)
                	return indexMap;
            }
        }
	}
    return null;

}
public  String getKeyValue2(java.util.Map<String, Object> jsonMap, String findKey) {

	//	logger.info("Inside 2nd rec...");
	Object indexkey = null;
	String indexValue = ""; 	
	
    for(Object key:(jsonMap.keySet())){
    	indexkey = key;
    	//	logger.info("2nd Keys of Json  "+jsonMap.toString() + findKey+ "!=" + key.toString()+"#");
    	
        if(findKey.equals(key.toString())){
        	 indexkey = key;
        	 indexValue = jsonMap.get(indexkey).toString();
        	 logger.info("2nd recurssion Its working : " + "Product Description:"+indexValue);
    	     return indexValue;
	        }else{

            if(jsonMap.get(key) instanceof java.util.Map){
            	logger.info("2nd Keys of Json  "+jsonMap.toString() + findKey+ "!=" + key.toString()+"#");
                indexValue =  getKeyValue2((java.util.Map<String, Object>)jsonMap.get(key), findKey);
                if (indexValue != "")
                	break;
                
             }
  
        }
    	
    }
    return indexValue;

}


}
