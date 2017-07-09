package com.java.service;

import java.util.List;

import com.java.model.Employee;

public interface EmployeeService {

	public abstract void addEmployee(Employee employee);

	public abstract Employee fetchEmployeeById(int empid);

	public abstract void deleteEmployeeById(int empid);

	public abstract void updateEmployeeEmailById(String newemail, int empid);

	public abstract List<Employee> getAllEmployeeInfo();

}
