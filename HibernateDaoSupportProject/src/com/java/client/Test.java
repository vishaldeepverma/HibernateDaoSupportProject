package com.java.client;
import java.util.List;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.java.model.Employee;
import com.java.service.impl.EmployeeServiceimpl;

public class Test {
	public static void main(String[] args) {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		EmployeeServiceimpl employeeService = context.getBean("employeeService", EmployeeServiceimpl.class);

		createEmployee(employeeService);
		//getEmployeeById(employeeService);
		//fetchAllEmployeeInfo(employeeService);
		//employeeService.updateEmployeeEmailById("halua@pagal.com",2);
		//employeeService.deleteEmployeeById(1);
		context.close();
	}

	private static void fetchAllEmployeeInfo(EmployeeServiceimpl employeeService) {
		List<Employee> allEmployeeInfo = employeeService.getAllEmployeeInfo();
		for (Employee employee : allEmployeeInfo) {
			System.out.println(employee.getEmail() + "--" + employee.getEmpname() + "--" + employee.getGender() + "--"
					+ employee.getSalary());
		}
	}

	private static void getEmployeeById(EmployeeServiceimpl employeeService) {
		Employee employee = employeeService.fetchEmployeeById(1);
		System.out.println(employee.getEmail() + "--" + employee.getEmpname() + "--" + employee.getGender() + "--"
				+ employee.getSalary());
	}

	private static void createEmployee(EmployeeServiceimpl employeeService) {
		Employee employee = new Employee();
		employee.setEmail("akashdeepverma@juju	.com");
		employee.setEmpname("Vishal Deep Verma");
		employee.setGender("Male");
		employee.setSalary(100002);
		employeeService.addEmployee(employee);
	}
}
