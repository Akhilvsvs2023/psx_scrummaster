package com.posidex.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "psx_users")
public class User {

	@Id
	@Column(name = "user_id")
	private String userId;
	@Column(name = "password")
	private String password;
	@Column(name = "emp_id")
	private String empId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "department_name")
	private String departmentName;
	@Column(name = "role")
	private String role;
	@Column(name = "email_id")
	private String emailId;
	@Column(name = "reporting_to")
	private String reportingTo;
	@Column(name = "created_on")
	private Date createdOn;
	@Column(name = "approved_on")
	private Date approvedOn;
	@Column(name = "active")
	private String active;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getReportingTo() {
		return reportingTo;
	}

	public void setReportingTo(String reportingTo) {
		this.reportingTo = reportingTo;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getApprovedOn() {
		return approvedOn;
	}

	public void setApprovedOn(Date approvedOn) {
		this.approvedOn = approvedOn;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", empId=" + empId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", departmentName=" + departmentName + ", role=" + role + ", emailId="
				+ emailId + ", reportingTo=" + reportingTo + ", createdOn=" + createdOn + ", approvedOn=" + approvedOn
				+ ", active=" + active + "]";
	}

	public User(String userId, String password, String empId, String firstName, String lastName, String departmentName,
			String role, String emailId, String reportingTo, Date createdOn, Date approvedOn, String active) {
		super();
		this.userId = userId;
		this.password = password;
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.departmentName = departmentName;
		this.role = role;
		this.emailId = emailId;
		this.reportingTo = reportingTo;
		this.createdOn = createdOn;
		this.approvedOn = approvedOn;
		this.active = active;
	}

	public User() {
		super();
	}

}
