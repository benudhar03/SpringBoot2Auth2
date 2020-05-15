package com.baseoauth.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.baseoauth.config.AuthUserDetails;
import com.baseoauth.entity.UserEntity;
import com.baseoauth.repository.UserRepository;

@Service
public class BaseServiceImpl implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserEntity> optionaUser = userRepository.findByUserName(username); 
		optionaUser.orElseThrow(()-> new UsernameNotFoundException("UserName or Password Wrong"));
		
		UserDetails userDetails = new AuthUserDetails(optionaUser.get());
		new AccountStatusUserDetailsChecker().check(userDetails); 
		return userDetails;
	}
}
