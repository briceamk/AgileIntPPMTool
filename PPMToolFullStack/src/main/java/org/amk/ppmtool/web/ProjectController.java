package org.amk.ppmtool.web;

import org.amk.ppmtool.domain.Project;
import org.amk.ppmtool.service.ProjectService;
import org.amk.ppmtool.service.ValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ValidationErrorService validationErrorService;

    @PostMapping
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){
        ResponseEntity<?> errorMap = validationErrorService.mapValidationService(result);
        if(errorMap!=null) 
            return errorMap;
        Project project1 = projectService.saveOrUpdateProject(project);
        return new ResponseEntity<Project>(project1, HttpStatus.CREATED);
    }
    @GetMapping("/{projectIdentifier}")
    public ResponseEntity<Project> getProjectByProjectIdentifier(@PathVariable String projectIdentifier){
        Project project = projectService.findByProjectIdentifier(projectIdentifier);
        return new ResponseEntity<Project>(project,HttpStatus.OK);
    }
}
