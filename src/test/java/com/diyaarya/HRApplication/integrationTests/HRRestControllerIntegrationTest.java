package com.diyaarya.HRApplication.integrationTests;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.diyaarya.HRApplication.Repository.HRRepository;
import com.diyaarya.HRApplication.model.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest(
		        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
		        //classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource(
		            locations = "classpath:application-integrationtest.properties")
public class HRRestControllerIntegrationTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private HRRepository hrRepository;

	@Test
	public void givenEmployeeName_whenGetEmployee_thenStatus200() throws Exception{
		//fail("Not yet implemented");
		Employee employee = new Employee("abc");
		
		mockMvc.perform(post("/addEmployee/")
				        .contentType(MediaType.APPLICATION_JSON)
				        .content("{\"name\":\"abc\",\"id\":1}"))
				        .andExpect(status().isCreated());
				        
		
		mockMvc.perform(get("/employee/"+ employee.getName())
				        .contentType(MediaType.APPLICATION_JSON))				        
		                .andExpect(status().isOk())
		                .andExpect(content().string("{\"name\":\"abc\",\"id\":1}"))	                
		                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		                .andExpect(jsonPath("$.name", is(employee.getName())));		                
	}

}
