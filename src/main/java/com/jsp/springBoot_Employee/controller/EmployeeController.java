package com.jsp.springBoot_Employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springBoot_Employee.dao.EmployeeDao;
import com.jsp.springBoot_Employee.dto.Employee;
import com.jsp.springBoot_Employee.service.EmployeeService;
import com.jsp.springBoot_Employee.util.ResponceStructure;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeDao dao;
	
	@Autowired
	private EmployeeService service;

	@PostMapping("/save")
	public ResponceStructure<Employee> saveEmployee(@RequestBody Employee employee) { // to take body from front end we use @RequestBody
		return service.saveEmployee(employee);

	}
	@GetMapping("/fetch")
	public Employee getEmployee(@RequestParam int id) {  //@RepositoryParamater
		return dao.getEmployee(id);	
	}
	@GetMapping("/fetchAll")
	public List<Employee> getAllEmployees(){
		return dao.getAll();
	}
	@DeleteMapping("/delete/{id}")
	public Employee deleteEmployee(@PathVariable int id) {
		return dao.delete(id);
	}
	
	@PutMapping("/update")//here we can use @Request
	public Employee updateEmployee(@RequestParam int id, @RequestBody Employee employee) {
		return service.updateEmployee(id, employee);
	}
	
	@PatchMapping("/updatesal")
	public Employee updateSalary(@RequestParam int id,@RequestParam double sal) {
		return service.updateSal(id, sal);//sal should be write in postman
		
	}
	@GetMapping("/findByEmail")
	public Employee findByEmail(@RequestParam String email) {
		return dao.findByEmail(email);
		
	}
	@GetMapping("/findByPhone/{phone}")
	public Employee findByPhone(@PathVariable long phone) {
		return dao.findByPhone(phone);
		
	}
	@GetMapping("/findBySal/{salary}")
	public List<Employee> findBySal(@PathVariable double salary){
		return dao.findByEmpFromSal(salary);
	}
}