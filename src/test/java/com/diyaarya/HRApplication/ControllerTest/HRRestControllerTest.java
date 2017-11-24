package com.diyaarya.HRApplication.ControllerTest;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import static org.springframework.test.web.servlet.result.hasSize;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.diyaarya.HRApplication.controller.HRRestController;
import com.diyaarya.HRApplication.model.Employee;
import com.diyaarya.HRApplication.services.EmployeeService;

@RunWith(SpringRunner.class)
@WebMvcTest(HRRestController.class)
public class HRRestControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private EmployeeService employeeService;

	@Test
	public void testGetEmployee() throws Exception{
		//fail("Not yet implemented");
		Employee employee = new Employee("abc");
		//List<Employee> allEmployees = Arrays.asList(vam);
		
		//given(employeeService.getEmployee(vam.getName())).willReturn(vam);
		
		mockMvc.perform(post("/addEmployee/")
		        .contentType(MediaType.APPLICATION_JSON)
		        .content("{\"name\":\"abc\",\"id\":1}"))
		        .andExpect(status().isCreated());
		
		mockMvc.perform(get("/employee/"+ employee.getName())
				.contentType(MediaType.APPLICATION_JSON))
		        .andExpect(status().isOk());
		        //.andExpect(jsonPath("$.name", is(employee.getName())));
		        //.andExpect(jsonPath("$", hasSize(1)));
		        //.andExpect(jsonPath(""))
	}

}
