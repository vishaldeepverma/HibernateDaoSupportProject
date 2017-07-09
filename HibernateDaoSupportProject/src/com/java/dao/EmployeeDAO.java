package com.java.dao;

import java.util.List;

import com.java.model.Employee;

public interface EmployeeDAO {
	public abstract void createEmployee(Employee employee);

	public abstract Employee getEmployeeById(int empid);

	public abstract void deleteEmployeeById(int empid);

	public abstract void updateEmployeeEmailById(String newemail, int empid);

	public abstract List<Employee> getAllEmployeeDetails();
}
