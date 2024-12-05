package com.managerservice.service;

import java.util.List;

import com.managerservice.entity.Staff;

public interface StaffService {
	Staff saveStaff(Staff staff);

	Staff modifyStaff(Staff staff);

	String removeStaff(int id);

	List<Staff> getAllStaff();

	Staff getByStaffId(int id);

}
