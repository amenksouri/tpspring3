package com.example.tpbase.Service.impl;

import com.example.tpbase.Service.IProjectService;
import com.example.tpbase.model.Employee;
import com.example.tpbase.model.Project;
import com.example.tpbase.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements IProjectService {
    @Autowired
     ProjectRepository projectRepository;

    @Override
    public Project saveEmployee(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public List<Project> getAllProjects() {
        return (List<Project>) projectRepository.findAll();
    }

    @Override
    public Project getProjectById(Long id) {
        Optional<Project> op = projectRepository.findById(id);
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
    public void deleteProjectById(Long id) {
        projectRepository.delete(getProjectById(id));
    }

    @Override
    public void updateProject(Project project) {
        projectRepository.save(project);
    }
}
