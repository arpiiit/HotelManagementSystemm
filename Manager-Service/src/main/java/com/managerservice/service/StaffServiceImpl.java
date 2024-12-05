package com.managerservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.managerservice.entity.Staff;
import com.managerservice.exception.InvalidEmailAddressException;
import com.managerservice.exception.InvalidMobileNumberException;
import com.managerservice.exception.StaffNotAvailableException;
import com.managerservice.exception.StaffNotFoundWithIdException;
import com.managerservice.repository.StaffRepository;

@Service
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffRepository staffRepository;
	@Autowired
	private SequenceGeneratorService seqService;


	@Override
	public Staff saveStaff(Staff staff) {
		// TODO Auto-generated method stub
		staff.setEmpId(seqService.getSequenceNumber(Staff.SEQUENCE_NAME));
		if(staff.getEmpPhone().matches("^[6-9]{1}[0-9]{9}$"))
		{
			if(staff.getEmpEmail().matches("^[A-Za-z]*[0-9]*[@]{1}[a-z]*[.]{1}[a-z]*$"))
			{
				return staffRepository.save(staff);
			}
			else
				throw new InvalidEmailAddressException("Invalid Email Address "+staff.getEmpEmail());
		}
		else throw new InvalidMobileNumberException("Invalid Mobile Number Exception "+staff.getEmpPhone());

		
	}

	@Override
	public Staff modifyStaff(Staff staff) {
		// TODO Auto-generated method stub
		Optional<Staff> foundStaff = staffRepository.findById(staff.getEmpId());
		if (foundStaff.isEmpty()) {
			throw new StaffNotFoundWithIdException("Staff not found with Id " + staff.getEmpId());
		}
		return staffRepository.save(staff);
	}

	@Override
	public String removeStaff(int id) {
		// TODO Auto-generated method stub
		Optional<Staff> staff = staffRepository.findById(id);
		if (staff.isEmpty()) {
			throw new StaffNotFoundWithIdException("Staff not found with Id " + id);
		}
		staffRepository.deleteById(id);
		return "Successfully deleted with id " + id;
	}

	@Override
	public List<Staff> getAllStaff() {
		// TODO Auto-generated method stub
		List<Staff> list = staffRepository.findAll();
		if (list.isEmpty()) {
			throw new StaffNotAvailableException("No staff is present");
		}
		return list;
	}

	@Override
	public Staff getByStaffId(int id) {
		// TODO Auto-generated method stub
		Optional<Staff> staff = staffRepository.findById(id);
		if (staff.isEmpty()) {
			throw new StaffNotFoundWithIdException("Staff not found with Id " + id);
		}

		return staff.get();
	}

}
