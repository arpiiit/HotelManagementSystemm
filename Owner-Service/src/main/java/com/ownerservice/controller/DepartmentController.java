package com.ownerservice.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.ownerservice.models.Department;
import com.ownerservice.service.DepartmentService;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/add")
	public ResponseEntity<Department> registerDepartment(@Valid @RequestBody Department department) {
		Department registeredDepartment = departmentService.addDepartment(department);
		return new ResponseEntity<>(registeredDepartment, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Department> updateDepartment(@Valid @RequestBody Department department) {
		Department updatedDepartment = departmentService.modifyDepartment(department);
		return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{deptId}")
	public ResponseEntity<String> deleteDepartment(@PathVariable("deptId") int id) {
		departmentService.removeDepartment(id);
		return new ResponseEntity<>("Department deleted successfully with " + id, HttpStatus.OK);
	}
	@GetMapping("/all")
	public ResponseEntity<List<Department>> fetchAllDepartments()
	{
	List<Department> list=departmentService.getAllDepartments();
	return new ResponseEntity<>(list,HttpStatus.OK);
	}

}
