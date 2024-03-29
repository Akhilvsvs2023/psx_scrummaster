package com.posidex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.posidex.entity.UserOps;
import com.posidex.repository.UserOpsRepository;

import jakarta.transaction.Transactional;

@Service
public class UserOpsServiceImpl implements UserOpsServiceI {

	@Autowired
	private UserOpsRepository userOpsRepository;

	@Transactional
	@Override
	public void addUserOps(UserOps userOps) {
		userOpsRepository.save(userOps);
	}

	@Override
	public List<UserOps> getUserOpsByUsername(String username) {
		return userOpsRepository.findByUserOpsIdentityUsername(username);
	}

}