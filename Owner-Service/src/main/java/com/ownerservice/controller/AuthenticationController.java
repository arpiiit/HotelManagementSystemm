package com.ownerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ownerservice.exception.InvalidCredentialsException;
import com.ownerservice.models.AuthenticationRequest;
import com.ownerservice.models.AuthenticationResponse;
import com.ownerservice.models.LoginResponse;
import com.ownerservice.models.Owner;
import com.ownerservice.repository.OwnerRepository;
import com.ownerservice.service.JwtUtil;
import com.ownerservice.service.OwnerDetailsService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/api")
public class AuthenticationController 
{
	@Autowired
	private OwnerDetailsService ownerService;
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@Autowired
	private OwnerRepository ownerRepository;
	

	@PostMapping("/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new InvalidCredentialsException("Incorrect username or password");
		}


		final UserDetails userDetails = ownerService
				.loadUserByUsername(authenticationRequest.getUserName());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new LoginResponse(userDetails.getUsername(), userDetails.getPassword(), jwt));
	}
	
	@PostMapping("/signup")
	public ResponseEntity<String> registerOwner(@RequestBody Owner owner)
	{
		ownerRepository.save(owner);
		return new ResponseEntity<String>("Registered SuccessFully",HttpStatus.CREATED);
	}
}
