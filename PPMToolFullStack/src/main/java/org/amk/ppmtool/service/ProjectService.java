package org.amk.ppmtool.service;

import org.amk.ppmtool.domain.Project;
import org.amk.ppmtool.exception.ProjectIdException;
import org.amk.ppmtool.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){
        try{
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        }catch (Exception e){
            throw new ProjectIdException("Project ID '"+project.getProjectIdentifier().toUpperCase()+"' already exists");
        }

    }

    public Project findByProjectIdentifier(String projectIdentifier){
        Project project = projectRepository.findByProjectIdentifierIgnoreCase(projectIdentifier);
        if(project==null)
            throw new ProjectIdException("Project ID '"+projectIdentifier.toUpperCase()+"' does not exist");
        return project;
    }

    public Iterable<Project> findAllProject(){
        Iterable<Project> projects = projectRepository.findAll();
        return projects;
    }
}
