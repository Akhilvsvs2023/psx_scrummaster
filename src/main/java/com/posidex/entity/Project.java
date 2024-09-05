package com.posidex.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "scrum_projects")
public class Project {
	
	@Id
	@Column(name = "project_id")
	private String projectId;
	@Column(name = "project_name")
	private String projectName;
	@Column(name = "description")
	private String description;
	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "department")
	private String department;
	@Column(name = "team_involved")
	private String teamInvolved;
	@Column(name = "created_on")
	private Date createdOn;
	@Column(name = "closed_on")
	private Date closedOn;
	@Column(name = "active")
	private int active;
	@Column(name = "lchgtime")
	private Date lchgtime;
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getTeamInvolved() {
		return teamInvolved;
	}
	public void setTeamInvolved(String teamInvolved) {
		this.teamInvolved = teamInvolved;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Date getClosedOn() {
		return closedOn;
	}
	public void setClosedOn(Date closedOn) {
		this.closedOn = closedOn;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public Date getLchgtime() {
		return lchgtime;
	}
	public void setLchgtime(Date lchgtime) {
		this.lchgtime = lchgtime;
	}
	public Project(String projectId, String projectName, String description, String createdBy, String department,
			String teamInvolved, Date createdOn, Date closedOn, int active, Date lchgtime) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.description = description;
		this.createdBy = createdBy;
		this.department = department;
		this.teamInvolved = teamInvolved;
		this.createdOn = createdOn;
		this.closedOn = closedOn;
		this.active = active;
		this.lchgtime = lchgtime;
	}
	public Project() {
		super();
	}
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", description=" + description
				+ ", createdBy=" + createdBy + ", department=" + department + ", teamInvolved=" + teamInvolved + ", createdOn="
				+ createdOn + ", closedOn=" + closedOn + ", active=" + active + ", lchgtime=" + lchgtime + "]";
	}
	
	
}
