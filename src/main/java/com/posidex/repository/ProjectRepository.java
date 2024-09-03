package com.posidex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.posidex.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {
	@Query(value = "SELECT * FROM scrum_projects p WHERE p.project_id = ?1 ", nativeQuery = true)
	public Project getProjectByprojectId(String id);
}
