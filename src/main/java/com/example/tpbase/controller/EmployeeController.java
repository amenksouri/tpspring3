package com.example.tpbase.controller;

import com.example.tpbase.Service.IEmployeeService;
import com.example.tpbase.model.Computer;
import com.example.tpbase.model.Employee;
import com.example.tpbase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService service;
    @GetMapping("/")
    public String showHomePage() {
        return "index";
    }

    @GetMapping("/getAllEmployees")
    public String getAllEmployees(
            @RequestParam(value = "message", required = false)
            String message,
            Model model
    ) {
        List<Employee> employees= service.getAllEmployees();
        model.addAttribute("list", employees);
        model.addAttribute("message", message);
        return "allEmployeesPage";
    }
}
