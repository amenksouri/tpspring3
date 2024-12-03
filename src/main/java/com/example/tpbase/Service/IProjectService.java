package com.example.tpbase.Service;

import com.example.tpbase.model.Project;

import java.util.List;

public interface IProjectService {

    public Project saveEmployee(Project project);
    public List<Project> getAllProjects();
    public Project getProjectById(Long id);
    public void deleteProjectById(Long id);
    public void updateProject(Project project);
}
