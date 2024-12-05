package com.managerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.managerservice.entity.Manager;
import com.managerservice.service.ManagerService;

@RestController
@RequestMapping("/manager")
public class ManagerController 
{
 
	@Autowired
	private ManagerService managerService;
	
	
	@GetMapping("/all")
	public ResponseEntity<List<Manager>> fetchAllManagers()
	{
		List<Manager> list=managerService.getAllManagers();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	

	
}
