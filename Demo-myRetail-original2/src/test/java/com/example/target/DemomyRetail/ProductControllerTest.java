package com.example.target.DemomyRetail;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.context.WebApplicationContext;


import com.example.target.DemomyRetail.model.*;
import com.example.target.DemomyRetail.DemoMyRetailApplicationTests;
import com.example.target.DemomyRetail.controller.ProductController;
import com.example.target.DemomyRetail.service.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductControllerTest {

	
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Test
	void contextLoads() {
		System.out.println("Inside Test app");
		assertTrue(true);

	}
	/*
	@Test
	public void ExtApiCallMockitoStub() {
		// TODO Auto-generated constructor stub
		String prodDesc = "The Big Lebowski (Blu-ray)";
		
		ExtApiCall extApiCallService = mock(ExtApiCall.class);
	
			String title = extApiCallService.getProductInfoFromExtApi(13860428, "title");
			System.out.println("String returned by :" +title);
			when(extApiCallService.getProductInfoFromExtApi(Mockito.any(), Mockito.anyString())).thenReturn(prodDesc);
			TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
			List<String> todos = todoBusinessImpl
					.retrieveTodosRelatedToSpring("Ranga");
					
			assertEquals(extApiCallService.getProductInfoFromExtApi(15117729, "title"), prodDesc);
		}
	
*/

	@Test
	public void getProductInfoTestPositive() throws Exception {
		
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

		String url = "/products/13860428";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON_VALUE);
		
		// Actual Result

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		// Expected Result
		String expectedProductJson ="{\"id\":13860428,\"name\":\"The Big Lebowski (Blu-ray)\",\"price\":{\"value\":5.1,\"currency_code\":\"$ USD\"}}";
		JSONAssert.assertEquals(expectedProductJson, result.getResponse().getContentAsString(), false);
	}
		
	@Test
	public void getProductInfoTestNegative() throws Exception {
		
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

	
		String url = "/products/15117729";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON_VALUE);
		
		// Actual Result

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		// Expected Result
		String expectedProductJson ="{\"id\":13860428,\"name\":\"The Big Lebowski (Blu-ray)\",\"price\":{\"value\":8.1,\"currency_code\":\"$ USD\"}}";
		JSONAssert.assertEquals(expectedProductJson, result.getResponse().getContentAsString(), false);
	}
	
}
	


