package com.managerservice.service;

import java.util.List;

import com.managerservice.entity.Manager;

public interface ManagerService {

	Manager addManager(Manager manager);

	List<Manager> getAllManagers();

}
