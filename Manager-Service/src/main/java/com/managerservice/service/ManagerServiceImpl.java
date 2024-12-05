package com.managerservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.managerservice.entity.Manager;
import com.managerservice.repository.ManagerRepository;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private ManagerRepository managerRepository;
	
	
	@Override
	public Manager addManager(Manager manager) {
		// TODO Auto-generated method stub
		
		Manager savedManager = managerRepository.save(manager);
		return savedManager;
	}

	@Override
	public List<Manager> getAllManagers() {
		// TODO Auto-generated method stub

		return managerRepository.findAll();
	}

}
