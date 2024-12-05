package com.receptionistservice.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.receptionistservice.exception.ReceptionistNotFoundException;
import com.receptionistservice.models.User;
import com.receptionistservice.repository.ReceptionistRepository;

@Service
public class ReceptionistDetailsService implements UserDetailsService{

	@Autowired
	private ReceptionistRepository receptionistRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user= receptionistRepository.findByUserName(username);
		if(user==null)
		{
			throw new ReceptionistNotFoundException(" Receptionist not found with username "+username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),new ArrayList<>());
	}

}
