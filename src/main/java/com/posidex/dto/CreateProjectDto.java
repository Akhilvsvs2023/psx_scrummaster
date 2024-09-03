package com.posidex.dto;

import java.util.List;

public class CreateProjectDto {
	private String projectName;
	private String description;
	private String createdBy;
	private List<String> projectMembers;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public List<String> getProjectMembers() {
		return projectMembers;
	}

	public void setProjectMembers(List<String> projectMembers) {
		this.projectMembers = projectMembers;
	}

	public CreateProjectDto(String projectName, String description, String createdBy, List<String> projectMembers) {
		super();
		this.projectName = projectName;
		this.description = description;
		this.createdBy = createdBy;
		this.projectMembers = projectMembers;
	}

	public CreateProjectDto() {
		super();
	}

	@Override
	public String toString() {
		return "CreateProjectDto [projectName=" + projectName + ", description=" + description + ", createdBy="
				+ createdBy + ", projectMembers=" + projectMembers + "]";
	}

}
