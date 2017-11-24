package com.diyaarya.HRApplication.ServiceTest;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.diyaarya.HRApplication.Repository.HRRepository;
import com.diyaarya.HRApplication.model.Employee;
import com.diyaarya.HRApplication.services.EmployeeService;

@RunWith(SpringRunner.class)
public class EmployeeServiceTest {
	
	@TestConfiguration
	static class EmployeeServiceImplTestContextConfiguration{
		@Bean
		public EmployeeService employeeService(){
			return new EmployeeService();
		}
	}
	
	@Autowired
	private EmployeeService employeeService;
	
	@MockBean
	private HRRepository hrRepository;
	
	@Before
	public void setUp(){
		Employee vam = new Employee("vam");
		
		Mockito.when(hrRepository.findByName(vam.getName())).thenReturn(vam);
	}

	@Test
	public void testGetEmployee() {
		//fail("Not yet implemented");
		String name = "vam";
		Employee found = employeeService.getEmployee(name);
		
		assertThat(found.getName()).isEqualTo(name);
	}

}
