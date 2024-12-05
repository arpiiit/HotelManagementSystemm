package com.managerservice.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.managerservice.exception.ManagerNotFoundException;
import com.managerservice.models.User;
import com.managerservice.repository.ManagerRepository;

@Service
public class ManagerDetailsService implements UserDetailsService {

	@Autowired
	private ManagerRepository managerRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=managerRepository.findByUserName(username);
		if(user==null)
		{
			throw new ManagerNotFoundException("Manager Not found With userName "+username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),new ArrayList<>());
	}

}
