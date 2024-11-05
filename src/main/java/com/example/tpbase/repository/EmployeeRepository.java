package com.example.tpbase.repository;

import com.example.tpbase.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    /*JPQL Query*/
    @Query("Select e from Employee e where e.department.id = ?1")
    List<Employee> FindByDepartement(Long Dep_id);

}
