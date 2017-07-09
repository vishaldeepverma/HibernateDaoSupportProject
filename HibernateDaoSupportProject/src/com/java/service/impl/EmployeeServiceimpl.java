package com.java.service.impl;

import java.util.List;

import com.java.dao.EmployeeDAO;
import com.java.model.Employee;
import com.java.service.EmployeeService;

public class EmployeeServiceimpl implements EmployeeService {

	private EmployeeDAO employeeDAO;

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	public void addEmployee(Employee employee) {
		employeeDAO.createEmployee(employee);

	}

	@Override
	public Employee fetchEmployeeById(int empid) {
		Employee employeeById = employeeDAO.getEmployeeById(empid);
		return employeeById;
	}

	@Override
	public void deleteEmployeeById(int empid) {
		employeeDAO.deleteEmployeeById(empid);
	}

	@Override
	public void updateEmployeeEmailById(String newemail, int empid) {
		employeeDAO.updateEmployeeEmailById(newemail, empid);
		
	}

	@Override
	public List<Employee> getAllEmployeeInfo() {
		List<Employee> allEmployeeDetails = employeeDAO.getAllEmployeeDetails();
		return allEmployeeDetails;
	}

}
