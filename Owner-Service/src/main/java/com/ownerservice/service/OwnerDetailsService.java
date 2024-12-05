package com.ownerservice.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ownerservice.exception.OwnerNotFoundException;
import com.ownerservice.models.User;
import com.ownerservice.repository.OwnerRepository;

@Service
public class OwnerDetailsService implements UserDetailsService{
	
	@Autowired
	private OwnerRepository ownerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=ownerRepository.findByUserName(username);
		if(user==null)
		{
			throw new OwnerNotFoundException("Owner not found with UserName "+username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),new ArrayList<>());
	}

}
