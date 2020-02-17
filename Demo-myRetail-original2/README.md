# myRetail RESTful service

myRetail is a rapidly growing company with HQ in Richmond, VA and over 200 stores across the east coast. myRetail wants to make its internal data available to any number of client devices, from myRetail.com to native mobile apps.
 
The goal for this exercise is to create an end-to-end Proof-of-Concept for a products API, which will aggregate product data from multiple sources and return it as JSON to the caller. 
Your goal is to create a RESTful service that can retrieve product and price details by ID. The URL structure is up to you to define, but try to follow some sort of logical convention.

Build an application that performs the following actions: 
Responds to an HTTP GET request at /products/{id} and delivers product data as JSON (where {id} will be a number. 

Example product IDs: 15117729, 16483589, 16696652, 16752456, 15643793) 

Example response: {"id":13860428,"name":"The Big Lebowski (Blu-ray) (Widescreen)","current_price":{"value": 13.49,"currency_code":"USD"}}

Performs an HTTP GET to retrieve the product name from an external API. (For this exercise the data will come from redsky.target.com, but let’s just pretend this is an internal resource hosted by myRetail)  

Example: http://redsky.target.com/v2/pdp/tcin/13860428?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics

Reads pricing information from a NoSQL data store and combines it with the product id and name from the HTTP request into a single response.  

BONUS: Accepts an HTTP PUT request at the same path (/products/{id}), containing a JSON request body similar to the GET response, and updates the product’s price in the data store.  




# Getting Started

#### Download tools
*	[Eclipse](https://www.eclipse.org/downloads/)
*	[apache-tomcat 9.0.30](https://tomcat.apache.org/download-90.cgi)
*	[postman](https://www.postman.com/downloads/)
*	[apache maven 3.6.3](https://maven.apache.org/download.cgi)
*	[jdk 13.0.2](https://www.oracle.com/java/technologies/javase-jdk13-downloads.html)
*	[mongodb-win32-x86_64-enterprise-windows-64-4.2.3](https://www.mongodb.com/download-center)

#### Step 2. Java classes
	
	Initial
	1. DemoMyRetailApplication
	2. IntialSetup
	Product
	1. ProductController 
	2. ProductService
	3. ProductModel 
	4. ProductRepository
	Product Description from External API
	1. ExtApiCall
	Custom Exceptions
	1. ProductCustomExceptions
	Security
	1.JwTAuthenticationEntryPoint
	2.JwtAuthenticationController
	3.JwtRequestFilter
	4.JwtTokenUtil 
	5.JwtUserDetailsService
	6.WebSecurityConfig

### Run examples

Rest API call GET to get product Info without Authentication
![alt text](https://github.com/AshuKoolkarni/Practice2/blob/master/Demo-myRetail/Demo-myRetail/Get%20prod%20with%20noAuth.png)

Rest API call POST to get Authentication token
![alt text](https://github.com/AshuKoolkarni/Practice2/blob/master/Demo-myRetail/Demo-myRetail/Authenticate.png)

Rest API call GET to get product info with authorization token 
![alt text](https://github.com/AshuKoolkarni/Practice2/blob/master/Demo-myRetail/Demo-myRetail/Get%20prod%20with%20Auth.png)

Rest API call PUT to update product info with authorization token 
![alt text](https://github.com/AshuKoolkarni/Practice2/blob/master/Demo-myRetail/Demo-myRetail/PUT%20prod%20price.png)

Rest API call GET to confirm product info is updated
![alt text](https://github.com/AshuKoolkarni/Practice2/blob/master/Demo-myRetail/Demo-myRetail/Confirm%20put.png)



### Test
	
	Mockito test - ProductControllerTest
![alt text](https://github.com/AshuKoolkarni/Practice2/blob/master/Demo-myRetail/Demo-myRetail/Unit%20test%20result.png)

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.4.RELEASE/maven-plugin/)
* [Spring Data MongoDB](https://docs.spring.io/spring-boot/docs/2.2.4.RELEASE/reference/htmlsingle/#boot-features-mongodb)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.2.4.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Security](https://docs.spring.io/spring-boot/docs/2.2.4.RELEASE/reference/htmlsingle/#boot-features-security)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)

