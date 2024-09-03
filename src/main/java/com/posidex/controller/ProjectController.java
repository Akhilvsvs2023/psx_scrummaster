package com.posidex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.posidex.dto.CreateProjectDto;
import com.posidex.dto.ResponseDTO;
import com.posidex.entity.Project;
import com.posidex.service.ProjectServiceI;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/project")
@RestController
public class ProjectController {
	
	@Autowired
	ProjectServiceI service;
	
	@PostMapping("/createProject")
	public ResponseDTO createUser(@RequestBody CreateProjectDto projectDto) {
		return service.createProject(projectDto);
	}
	
	@PostMapping("/getMyProject")
	public List<Project> getMyProject(@RequestBody String empId) {
		return service.getMyProject(empId);
	}
}
