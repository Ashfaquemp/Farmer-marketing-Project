package com.kootam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kootam.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User getUserByUsernameAndPassword(String username, String password);
	
}