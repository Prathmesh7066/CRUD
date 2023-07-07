package com.jsp.springBoot_Employee.repo;  

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.springBoot_Employee.dto.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	 Employee findByEmail(String email);
      
	 @Query("select e from Employee e where e.phone=?1")
	 Employee EmployeeByPhone(long phone);
	 
	 List<Employee> findBySalaryGreaterThan(double salary);//spring will create the query (findBy is manditory
}
