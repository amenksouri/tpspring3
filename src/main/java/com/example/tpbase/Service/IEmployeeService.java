package com.example.tpbase.Service;

import com.example.tpbase.model.Employee;

import java.util.List;

public interface IEmployeeService {
    public Employee saveEmployee(Employee employee);
    public List<Employee> getAllEmployees();
    public Employee getEmployeeById(Long id);
    public void deleteEmployeeById(Long id);
    public void updateEmployee(Employee employee);

}
