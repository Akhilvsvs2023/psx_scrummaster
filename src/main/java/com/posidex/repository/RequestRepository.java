package com.posidex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.posidex.entity.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, String> {
	
//	@Query(value = "SELECT * FROM scrum_user_requests r WHERE r.raised_by = ?1 and active = 1", nativeQuery = true)
//	Request getRequestsBasedOnUserAndOperation(String username);
	
	@Query(value = "SELECT * FROM scrum_requests r WHERE r.raised_to = ?1 and active = 1 and r.request_type = 'USER ACTIVATION'", nativeQuery = true)
	List<Request> getProfileActivationRequests(String username);
	
	
}
