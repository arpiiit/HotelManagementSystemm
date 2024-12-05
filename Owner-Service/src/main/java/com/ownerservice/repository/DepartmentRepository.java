package com.ownerservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ownerservice.models.Department;

public interface DepartmentRepository extends MongoRepository<Department, Integer>
{

}
