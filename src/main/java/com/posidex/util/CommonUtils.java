package com.posidex.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.posidex.enums.RoleEnums;

public class CommonUtils {
	public static final String dateFormat = "dd-MM-yyyy";
	public static final String founders = "Founders";
	public static final String vice_President = "Vice President";
	public static final String manager = "Manager";
	public static final String senior_Software_Engineer = "Senior Software Engineer";
	public static final String software_Engineer = "Software Engineer";
	public static final String associate_Software_Engineer = "Associate Software Engineer";
	public static final String trainee = "Trainee";

	public static String dateToString(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(CommonUtils.dateFormat);
		return dateFormat.format(date);
	}

	public static RoleEnums getRoleEnumFromDesignation(String role) {
		if (role.equals(founders)) {
			return RoleEnums.FOUNDER;
		} else if (role.equals(vice_President)) {
			return RoleEnums.VICEPRESIDENT;
		} else if (role.equals(manager)) {
			return RoleEnums.MANAGER;
		} else if (role.equals(senior_Software_Engineer)) {
			return RoleEnums.SENIORSOFTWAREENGINEER;
		} else if (role.equals(software_Engineer)) {
			return RoleEnums.SOFTWAREENGINEER;
		} else if (role.equals(associate_Software_Engineer)) {
			return RoleEnums.ASSOCIATESOFTWAREENGINEER;
		} else {
			throw new IllegalArgumentException("Unexpected value: " + role);
		}
	}

	public static Integer getLevelFromRoleEnums(RoleEnums enums) {
		switch (enums) {
		case FOUNDER: {
			return 1;
		}
		case VICEPRESIDENT: {
			return 2;
		}
		case MANAGER: {
			return 3;
		}
		case SENIORSOFTWAREENGINEER: {
			return 4;
		}
		case SOFTWAREENGINEER: {
			return 5;
		}
		case ASSOCIATESOFTWAREENGINEER: {
			return 6;
		}
		case TRAINEE: {
			return 7;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + enums);
		}
	}
}
