package com.posidex.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.posidex.dto.CreateProjectDto;
import com.posidex.dto.ResponseDTO;
import com.posidex.entity.Project;
import com.posidex.entity.UserDetails;
import com.posidex.enums.RoleEnums;
import com.posidex.repository.ProjectRepository;
import com.posidex.util.CommonStringUtils;
import com.posidex.util.CommonUtils;

@Service
public class ProjectServiceImpl implements ProjectServiceI {
	
	@Autowired
	ProjectRepository repo;
	
	@Autowired UserDetailsServiceI userDetailsService;
	
	private static Logger logger = Logger.getLogger(ProjectServiceImpl.class.getName());

	@Override
	public ResponseDTO createProject(CreateProjectDto dto) {
		Project project = new Project();
		ResponseDTO response = new ResponseDTO();
		fillProject(dto,project);
		try {
			repo.save(project);
		}catch (Exception e) {
			logger.info(e.getMessage());
			response.setStatus(CommonStringUtils.FAILED);
			response.setMessage(e.getMessage());
		}
		response.setMessage("Project Created");
		response.setStatus(CommonStringUtils.SUCCESS);
		response.setStatusCode(200);
		return response;
	}

	private void fillProject(CreateProjectDto dto, Project project) {
		UserDetails details = userDetailsService.getUserDetailsByEmpId(dto.getCreatedBy());
		project.setProjectName(dto.getProjectName());
		project.setDescription(dto.getDescription());
		UUID id = UUID.randomUUID();
		while(repo.getProjectByprojectId(id.toString())!=null) {
			id = UUID.randomUUID();
		}
		project.setDepartment(details.getDepartmentName());
		project.setProjectId(id.toString());
		project.setCreatedBy(dto.getCreatedBy());
		project.setCreatedOn(new Date(System.currentTimeMillis()));
		project.setLchgtime(new Date(System.currentTimeMillis()));
		project.setActive(1);
		Map<String,List<String>> involvedMembers = new LinkedHashMap<>();
		dto.getProjectMembers().forEach(lead->{
			List<String> reporteesList = new ArrayList<>();
			userDetailsService.getReportees(lead).forEach(reportee->reporteesList.add(reportee.getEmpId()));
			involvedMembers.put(lead, reporteesList);
		});
		project.setTeamInvolved(new Gson().toJson(involvedMembers));
	}

	@Override
	public List<Project> getMyProject(String empId) {
		List<Project> retValue = new ArrayList<>();
		UserDetails userDetails = userDetailsService.getUserDetailsByEmpId(empId);
		RoleEnums role = CommonUtils.getRoleEnumFromDesignation(userDetails.getDesignation());
		switch (role) {
		case FOUNDER: {
			retValue = repo.findAll();
			break;
		}
		case VICEPRESIDENT: {
			retValue = repo.getProjectofReportees(userDetails.getEmpId());
			break;
		}
		default:
			List<Project> projectsList = repo.getProjectByDepartment(userDetails.getDepartmentName());
			for(Project project :projectsList) {
				if(project.getTeamInvolved().contains(empId)||project.getCreatedBy().equals(empId)) {
					retValue.add(project);
				}
			}
			break;
		}		
		return retValue;
	}

}