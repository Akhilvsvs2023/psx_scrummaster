package com.posidex.service;

import java.util.List;

import com.posidex.dto.CreateProjectDto;
import com.posidex.dto.ResponseDTO;
import com.posidex.entity.Project;

public interface ProjectServiceI {
	public ResponseDTO createProject(CreateProjectDto dto);
	public List<Project> getMyProject(String empId);
}
