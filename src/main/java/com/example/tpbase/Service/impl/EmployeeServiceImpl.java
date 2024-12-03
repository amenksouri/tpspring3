package com.example.tpbase.Service.impl;

import com.example.tpbase.Service.IEmployeeService;
import com.example.tpbase.model.Departement;
import com.example.tpbase.model.Employee;
import com.example.tpbase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> op = employeeRepository.findById(id);
        if(op.isPresent())
        {
            return op.get();
        }
        else
        {
            throw new NullPointerException("Employee avec l'Id "+ id +"n'existe pas");
        }
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.delete(getEmployeeById(id));
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
