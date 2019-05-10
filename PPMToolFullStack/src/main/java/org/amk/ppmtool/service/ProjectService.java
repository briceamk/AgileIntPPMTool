package org.amk.ppmtool.service;

import org.amk.ppmtool.domain.Project;
import org.amk.ppmtool.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){
        //Logic
        return projectRepository.save(project);
    }
}
