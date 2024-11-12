package com.example.tpbase.repository;

import com.example.tpbase.model.Employee;
import com.example.tpbase.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    Set<Project> findProjectsByEmployeesId(Long Id);

}
