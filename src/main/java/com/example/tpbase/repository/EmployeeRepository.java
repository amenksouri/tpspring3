package com.example.tpbase.repository;

import com.example.tpbase.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {


}
