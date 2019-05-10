package org.amk.ppmtool.exception;

public class ProjectIdExceptionResponse {
    private String projectIdetifier;

    public ProjectIdExceptionResponse(String projectIdetifier){
        this.projectIdetifier = projectIdetifier;
    }

    public String getProjectIdetifier() {
        return projectIdetifier;
    }

    public void setProjectIdetifier(String projectIdetifier) {
        this.projectIdetifier = projectIdetifier;
    }


}
