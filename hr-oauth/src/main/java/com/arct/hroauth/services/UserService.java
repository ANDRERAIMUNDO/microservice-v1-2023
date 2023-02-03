package com.arct.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.arct.hroauth.entities.User;
import com.arct.hroauth.feignclients.UserFeignClient;

@Service
public class UserService implements UserDetailsService {
	
	private static Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	public User findByEmail (String email) {
		User user = userFeignClient.findByEmail(email).getBody();
		if (user == null) {
			log.error ("Email " + email + " " + "não encotrado!");
			throw new IllegalArgumentException("Email não encontrado!");
		}
		log.info("Email " + email + " " + "encontrado!");
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userFeignClient.findByEmail(username).getBody();
		if (user == null) {
			log.error ("Email " + username + " " + "não encotrado!");
			throw new UsernameNotFoundException("Email não encontrado!");
		}
		log.info("Email " + username + " " + "encontrado!");
		return user;
	}
}
