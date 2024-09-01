package com.posidex.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "scrum_requests")
public class Request {
	@Id
	@Column(name = "request_id")
	private String requestId;
	@Column(name = "request_type")
	private String requestType;
	@Column(name = "raised_by")
	private String raisedBy;
	@Column(name = "raised_to")
	private String raisedTo;
	@Column(name = "operation_time")
	private Date operationTime;
	@Column(name = "active")
	private int active;

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getRaisedBy() {
		return raisedBy;
	}

	public void setRaisedBy(String raisedBy) {
		this.raisedBy = raisedBy;
	}

	public String getRaisedTo() {
		return raisedTo;
	}

	public void setRaisedTo(String raisedTo) {
		this.raisedTo = raisedTo;
	}

	public Date getOperationTime() {
		return operationTime;
	}

	public void setOperationTime(Date operationTime) {
		this.operationTime = operationTime;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Request(String requestId, String requestType, String raisedBy, String raisedTo, Date operationTime,
			int active) {
		super();
		this.requestId = requestId;
		this.requestType = requestType;
		this.raisedBy = raisedBy;
		this.raisedTo = raisedTo;
		this.operationTime = operationTime;
		this.active = active;
	}

	public Request() {
		super();
	}

	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", requestType=" + requestType + ", raisedBy=" + raisedBy
				+ ", raisedTo=" + raisedTo + ", operationTime=" + operationTime + ", active=" + active + "]";
	}

}
