package com.posidex.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.posidex.entity.UserDetails;
import com.posidex.repository.UserDetailsRepository;
import com.posidex.util.CommonUtils;

import jakarta.transaction.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsServiceI {

	@Autowired
	UserDetailsRepository userDetailsRepository;

	@Transactional
	@Override
	public void addUserDetails(UserDetails userDetails) {
		userDetailsRepository.save(userDetails);
	}

	@Override
	public UserDetails getUserDetailsByUsername(String username) {
		return userDetailsRepository.getUserDetailsByUsername(username);
	}

	@Override
	public List<UserDetails> getReportees(String empId) {
		return userDetailsRepository.getReporteesByEmpID(empId);
	}

	@Override
	public Map<String, List<UserDetails>> getTeamMemberDetatils(String username) {
		Map<String, List<UserDetails>> retValue = new LinkedHashMap<>();
		UserDetails currentUser = getUserDetailsByUsername(username);
		List<UserDetails> teamMembers = userDetailsRepository
				.getTeamMembersByDepartment(currentUser.getDepartmentName());
		List<UserDetails> traineeList = new ArrayList<>();
		List<UserDetails> vpList = new ArrayList<>();
		List<UserDetails> aSEList = new ArrayList<>();
		List<UserDetails> sEList = new ArrayList<>();
		List<UserDetails> sSEList = new ArrayList<>();
		List<UserDetails> mList = new ArrayList<>();
		teamMembers.forEach(x -> {
			if (x.getDesignation().equals(CommonUtils.manager)) {
				mList.add(x);
			} else if (x.getDesignation().equals(CommonUtils.senior_Software_Engineer)) {
				sSEList.add(x);
			} else if (x.getDesignation().equals(CommonUtils.software_Engineer)) {
				sEList.add(x);
			} else if (x.getDesignation().equals(CommonUtils.associate_Software_Engineer)) {
				aSEList.add(x);
			} else if (x.getDesignation().equals(CommonUtils.trainee)) {
				traineeList.add(x);
			} else if (x.getDesignation().equals(CommonUtils.vice_President)) {
				vpList.add(x);
			}
		});
		retValue.put("vp", vpList);
		retValue.put("pm", mList);
		retValue.put("sse", sSEList);
		retValue.put("se", sEList);
		retValue.put("ase", aSEList);
		retValue.put("t", traineeList);
		return retValue;
	}

	@Override
	public UserDetails getUserDetailsByEmpId(String empId) {
		return userDetailsRepository.getUserDetailsByEmpId(empId);
	}

}
