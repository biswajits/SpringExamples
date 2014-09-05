package net.jdbc.spring.dao;

import java.util.List;

import net.jdbc.spring.model.Employee;

public interface EmployeeDAO {
	
	//Create
		public void save(Employee employee);
		//Read
		public Employee getById(int id);
		//Update
		public void update(Employee employee);
		//Delete
		public void deleteById(int id);
		//Get All
		public List<Employee> getAll();

}
