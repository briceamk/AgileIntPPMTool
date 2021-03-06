package org.amk.ppmtool.repository;

import org.amk.ppmtool.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
    Project findByProjectIdentifierIgnoreCase(String projectIdentifier);

    @Override
    Iterable<Project> findAll();
}
