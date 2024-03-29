package com.posidex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.posidex.entity.UserOps;
import com.posidex.entity.UserOpsIdentity;

@Repository
public interface UserOpsRepository extends JpaRepository<UserOps, UserOpsIdentity> {

	List<UserOps> findByUserOpsIdentityUsername(String username);

}