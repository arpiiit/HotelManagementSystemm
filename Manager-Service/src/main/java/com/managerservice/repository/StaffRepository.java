package com.managerservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.managerservice.entity.Staff;

public interface StaffRepository extends MongoRepository<Staff, Integer>
{

}
