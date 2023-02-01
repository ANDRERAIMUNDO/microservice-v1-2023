package com.arct.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arct.hruser.entities.User;

public interface UserRepository extends JpaRepository <User, Long> {
	
	User findByEmail (String email);
}
