package com.receptionistservice.controller;

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

import com.receptionistservice.entity.Receptionist;
import com.receptionistservice.exception.InvalidCredentialsException;
import com.receptionistservice.models.AuthenticationRequest;
import com.receptionistservice.models.AuthenticationResponse;
import com.receptionistservice.models.LoginResponse;
import com.receptionistservice.repository.ReceptionistRepository;
import com.receptionistservice.service.JwtUtil;
import com.receptionistservice.service.ReceptionistDetailsService;
import com.receptionistservice.service.ReceptionistSequenceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/api")
public class AuthController {
	@Autowired
	private ReceptionistDetailsService receptionistService;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@Autowired
	private ReceptionistRepository receptionistRepository;
	
	@Autowired
	private ReceptionistSequenceImpl sequence1;

	
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


		final UserDetails userDetails = receptionistService
				.loadUserByUsername(authenticationRequest.getUserName());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new LoginResponse(userDetails.getUsername(), userDetails.getPassword(),jwt));
	}
	
	@PostMapping("/signup")
	public ResponseEntity<String> registerManager(@RequestBody Receptionist receptionist)
	{
		receptionist.setReceptionistId(sequence1.getSequenceNumber(Receptionist.SEQUENCE_NAME));
		receptionistRepository.save(receptionist);
		return new ResponseEntity<>("Registered Successfully ",HttpStatus.CREATED);
	}

}
