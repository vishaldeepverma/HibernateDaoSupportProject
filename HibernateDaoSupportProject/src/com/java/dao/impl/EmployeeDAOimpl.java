package com.java.dao.impl;
import java.util.List;
import javax.annotation.PostConstruct;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.java.dao.EmployeeDAO;
import com.java.model.Employee;

public class EmployeeDAOimpl extends HibernateDaoSupport implements EmployeeDAO {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public void createEmployee(Employee employee) {
		getHibernateTemplate().save(employee);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Employee getEmployeeById(int empid) {
		Employee employee =getHibernateTemplate().get(Employee.class, empid);
		return employee;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void deleteEmployeeById(int empid) {
		Employee employee = new Employee();
		employee.setEmpid(empid);
		getHibernateTemplate().delete(employee);
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public void updateEmployeeEmailById(String newemail, int empid) {
		Employee employee = hibernateTemplate.get(Employee.class, empid); 
		employee.setEmail(newemail);
		getHibernateTemplate().update(employee);
 
	}

	@Override
	public List<Employee> getAllEmployeeDetails() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		List<Employee> EmpList = (List<Employee>)getHibernateTemplate().findByCriteria(criteria);
		return EmpList;
	}
	
	@PostConstruct//JSR 250 Annotation
	public void init(){
		setHibernateTemplate(hibernateTemplate);
	}
}