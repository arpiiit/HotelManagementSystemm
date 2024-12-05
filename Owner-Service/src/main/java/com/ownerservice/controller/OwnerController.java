package com.ownerservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ownerservice.models.Owner;
import com.ownerservice.service.OwnerService;

@RestController
public class OwnerController {
	@Autowired
	private OwnerService ownerService;


	@GetMapping("/owner/all")
	public List<Owner> fetchAllOwner() {
		return ownerService.getAllOwners();
	}
}
