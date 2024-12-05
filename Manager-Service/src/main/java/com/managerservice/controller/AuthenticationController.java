package com.managerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.managerservice.entity.Manager;
import com.managerservice.exception.InvalidCredentialsException;
import com.managerservice.models.AuthenticationRequest;
import com.managerservice.models.AuthenticationResponse;
import com.managerservice.models.LoginResponse;
import com.managerservice.repository.ManagerRepository;
import com.managerservice.service.JwtUtil;
import com.managerservice.service.ManagerDetailsService;
import com.managerservice.service.SequenceServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/api")
public class AuthenticationController {
	
	@Autowired
	private ManagerDetailsService managerService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private SequenceServiceImpl sequence;

	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@Autowired
	private ManagerRepository managerRepository;
	
	@PostMapping("/signin")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new InvalidCredentialsException("Incorrect username or password");
		}


		final UserDetails userDetails = managerService
				.loadUserByUsername(authenticationRequest.getUserName());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new LoginResponse(userDetails.getUsername(), userDetails.getPassword(), jwt));
	}
	
	@PostMapping("/signup")
	public ResponseEntity<String> registerManager(@RequestBody Manager manager)
	{
		manager.setManagerId(sequence.getSequenceNumber(Manager.SEQUENCE_NAME));
		managerRepository.save(manager);
		return new ResponseEntity<>("Registered Successfully ",HttpStatus.CREATED);
	}

}
