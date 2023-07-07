package com.jsp.springBoot_Employee.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.springBoot_Employee.dto.Employee;
import com.jsp.springBoot_Employee.repo.EmployeeRepo;
import com.jsp.springBoot_Employee.util.ResponceStructure;

@Repository // for object creation in springboot
public class EmployeeDao {
	@Autowired // for connecting in spring we use this annotation
	private EmployeeRepo repo;

	public Employee saveEmployee(Employee employee) {
		return repo.save(employee);
	}

	public Employee getEmployee(int id) {
//		return repo.findById(id).get();
		// to avoid NoSuchElementException

		Optional<Employee> optional = repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public List<Employee> getAll() {
		return repo.findAll();
	}

	public Employee delete(int id) {
		Optional<Employee> e = repo.findById(id);
		if (e.isEmpty()) {
			return null;
		}
		repo.deleteById(id);
		return e.get();
	}

	public Employee update(int id, Employee employee) {
//		Employee dbEmployee = repo.findById(id).get();
		Optional<Employee>dbEmployee = repo.findById(id);
		if(dbEmployee.isPresent()) {
			
			employee.setId(id);
			return repo.save(employee);
		}
		return null;
	}
	
	public Employee updateSal(int id, double sal) {
		Optional<Employee>emp = repo.findById(id);
		if(emp.isPresent()) {
			Employee employee = emp.get();
			employee.setSalary(sal);
			return repo.save(employee);
		}
		return null;
	}
	public Employee findByEmail(String email) {
		 return repo.findByEmail(email);
	}
	public Employee findByPhone(long phone) {
		return repo.EmployeeByPhone(phone);
	}
	public List<Employee> findByEmpFromSal(double sal){
		return repo.findBySalaryGreaterThan(sal);
	}
}
