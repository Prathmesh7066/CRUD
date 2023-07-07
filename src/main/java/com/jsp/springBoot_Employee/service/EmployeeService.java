package com.jsp.springBoot_Employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.springBoot_Employee.dao.EmployeeDao;
import com.jsp.springBoot_Employee.dto.Employee;
import com.jsp.springBoot_Employee.repo.EmployeeRepo;
import com.jsp.springBoot_Employee.util.ResponceStructure;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao dao;

	ResponceStructure<Employee> structure = new ResponceStructure<>();

	public ResponceStructure<Employee> saveEmployee(Employee employee) {
		if (employee.getSalary() >= 0 && employee.getSalary() <= 10000) {
			employee.setGrade('D');
		} else if (employee.getSalary() >= 10001 && employee.getSalary() <= 20000) {
			employee.setGrade('C');
		} else if (employee.getSalary() >= 20001 && employee.getSalary() <= 30000) {
			employee.setGrade('B');
		} else {
			employee.setGrade('A');
		}

		structure.setMessage("Data saved successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveEmployee(employee));

		return structure;
	}

	public Employee updateEmployee(int id, Employee employee) {
		if (employee.getSalary() >= 0 && employee.getSalary() <= 10000) {
			employee.setGrade('D');
		} else if (employee.getSalary() >= 10001 && employee.getSalary() <= 20000) {
			employee.setGrade('C');
		} else if (employee.getSalary() >= 20001 && employee.getSalary() <= 30000) {
			employee.setGrade('B');
		} else {
			employee.setGrade('A');
		}

		return dao.update(id, employee);
	}

	public Employee updateSal(int id, double sal) {
		Employee employee = dao.getEmployee(id);

		if (employee.getSalary() >= 0 && employee.getSalary() <= 10000) {
			employee.setGrade('D');
		} else if (employee.getSalary() >= 10001 && employee.getSalary() <= 20000) {
			employee.setGrade('C');
		} else if (employee.getSalary() >= 20001 && employee.getSalary() <= 30000) {
			employee.setGrade('B');
		} else {
			employee.setGrade('A');
		}

		return dao.updateSal(id, sal);
	}

}
