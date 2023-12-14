package com.devsuperior.aulalazy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.aulalazy.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query("SELECT obj FROM Employee obj JOIN FETCH obj.department") //linguagem de consulta JPQL
	List<Employee> findEmployeesWithDepartments();

	List<Employee> findByNameIgnoreCase(String name);
}
