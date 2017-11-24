package com.diyaarya.HRApplication.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.diyaarya.HRApplication.model.Employee;

@Repository
public interface HRRepository extends CrudRepository<Employee, String> {
	
	public Employee findByName(String name);
	public Employee save(Employee employee);

}
