package com.example.tpbase.controller;

import com.example.tpbase.Service.IProjectService;
import com.example.tpbase.model.Employee;
import com.example.tpbase.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private IProjectService serivce;
    @GetMapping("/")
    public String showHomePage() {
        return "index";
    }

    @GetMapping("/getAllProjects")
    public String getAllProjects(
            @RequestParam(value = "message", required = false)
            String message,
            Model model
    ) {
        List<Project> projects= serivce.getAllProjects();
        model.addAttribute("list", projects);
        model.addAttribute("message", message);
        return "allProjectsPage";
    }

}
