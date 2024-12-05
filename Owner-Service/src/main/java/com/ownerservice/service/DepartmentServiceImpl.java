package com.ownerservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ownerservice.exception.DepartmentNotFoundWithId;
import com.ownerservice.models.Department;
import com.ownerservice.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private SequenceGeneratorService seqService;

	@Override
	public Department addDepartment(Department department) {
		// TODO Auto-generated method stub
		department.setDepartmentId(seqService.getSequenceNumber(Department.SEQUENCE_NAME));
		return departmentRepository.save(department);

	}

	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}

	@Override
	public Department modifyDepartment(Department department) {
		// TODO Auto-generated method stub
		Optional<Department> dpt = departmentRepository.findById(department.getDepartmentId());
		if (dpt.isEmpty()) {
			throw new DepartmentNotFoundWithId("Department not found with " + department.getDepartmentId());
		}

		return departmentRepository.save(department);
	}

	@Override
	public void removeDepartment(int id) {
		// TODO Auto-generated method stub
		Optional<Department> dpt = departmentRepository.findById(id);
		if (dpt.isEmpty()) {
			throw new DepartmentNotFoundWithId("Department not found with " + id);
		}
		departmentRepository.deleteById(id);

	}

}
