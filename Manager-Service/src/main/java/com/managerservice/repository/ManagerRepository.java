package com.managerservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.managerservice.entity.Manager;
import com.managerservice.models.User;

public interface ManagerRepository extends MongoRepository<Manager, Integer> {
	User findByUserName(String userName);
}
