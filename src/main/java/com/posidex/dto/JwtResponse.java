package com.posidex.dto;

import com.posidex.entity.UserDetails;

public class JwtResponse {
	private String jwtToken;
	private String message;
	private int statusCode;
	private UserDetails userDetails;
	private int level;

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public JwtResponse() {
		super();
	}

	public JwtResponse(String jwtToken, String message, int statusCode, UserDetails userDetails, int level) {
		super();
		this.jwtToken = jwtToken;
		this.message = message;
		this.statusCode = statusCode;
		this.userDetails = userDetails;
		this.level = level;
	}

	@Override
	public String toString() {
		return "JwtResponse [jwtToken=" + jwtToken + ", message=" + message + ", statusCode=" + statusCode
				+ ", userDetails=" + userDetails + ", level=" + level + "]";
	}

}