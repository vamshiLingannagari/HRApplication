package com.diyaarya.HRApplication.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.diyaarya.HRApplication.model.Employee;
import com.diyaarya.HRApplication.services.EmployeeService;

@RestController
public class HRRestController {
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value="/employee/{name}", method=RequestMethod.GET, headers="Accept=application/json")
	public Employee getEmployee(@PathVariable String name){		
		return employeeService.getEmployee(name);		
	}
	
	//@RequestMapping(value="/addEmployee", method=RequestMethod.POST, headers="Accept=application/json")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> addEmployee(@RequestBody @Valid Employee employee){		
		employee = employeeService.addEmployee(employee);		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
