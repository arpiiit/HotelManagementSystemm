package com.ownerservice.service;

import java.util.List;

import com.ownerservice.models.Department;

public interface DepartmentService {
	
	Department addDepartment(Department department);

	List<Department> getAllDepartments();
	
	Department modifyDepartment(Department department);
	
	void removeDepartment(int id);
}
