package com.example.target.DemomyRetail.Exceptions;

import java.lang.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductCustomExceptions extends RuntimeException
{
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	private static final long serialVersionUID = 1L;
	private static Throwable throwable = new Throwable("Error with super :");
	
    public ProductCustomExceptions(String message) {
    	
    	super(message, throwable );
		        
     }
	

}