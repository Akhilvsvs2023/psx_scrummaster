package com.posidex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.posidex.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {
	@Query(value = "SELECT * FROM scrum_projects p WHERE p.project_id = ?1 ", nativeQuery = true)
	public Project getProjectByprojectId(String id);
	
	@Query(value = "SELECT * FROM scrum_projects p WHERE p.department = ?1 ", nativeQuery = true)
	public List<Project> getProjectByDepartment(String department);
	@Query(value = "SELECT * FROM scrum_projects p WHERE p.created_by IN (SELECT u.emp_id FROM scrum_user_details u WHERE u.reporting_to = ?1)", nativeQuery = true)
	public List<Project> getProjectofReportees(String empId);
}
