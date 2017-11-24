package com.diyaarya.HRApplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diyaarya.HRApplication.Repository.HRRepository;
import com.diyaarya.HRApplication.model.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	HRRepository hrRepository;
	
	public Employee getEmployee(String name){
		if(name == null){
			return null;
		}
		return hrRepository.findByName(name);				
	}
	
	public Employee addEmployee(Employee employee){
		return hrRepository.save(employee);
	}
	
	

}
