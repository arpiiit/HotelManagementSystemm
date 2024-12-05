package com.managerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.managerservice.entity.Staff;
import com.managerservice.service.StaffService;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/staff")
public class StaffController 
{
 
	@Autowired
	private StaffService staffService;
	
	@PostMapping("/add")
	public ResponseEntity<Staff> registerStaff(@RequestBody Staff staff)
	{
		Staff savedStaff=staffService.saveStaff(staff);
		return new ResponseEntity<>(savedStaff,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Staff> updateStaff(@RequestBody Staff staff)
	{
		Staff updatedStaff=staffService.modifyStaff(staff);
		return new ResponseEntity<>(updatedStaff,HttpStatus.OK);
	}
	
	@GetMapping("/find/{empID}")
	public ResponseEntity<Staff> findByStaffId(@PathVariable("empID") int id)
	{
		Staff staff=staffService.getByStaffId(id);
		return new ResponseEntity<>(staff,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<String> deleteStaff(@PathVariable("empId") int id)
	{
		String msg=staffService.removeStaff(id);
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	@GetMapping("/all")
	public ResponseEntity<List<Staff>> fetchAllStaff()
	{
		List<Staff> list=staffService.getAllStaff();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
}
