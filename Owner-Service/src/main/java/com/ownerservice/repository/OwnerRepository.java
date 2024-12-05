package com.ownerservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ownerservice.models.Owner;
import com.ownerservice.models.User;

public interface OwnerRepository extends MongoRepository<Owner, Integer>
{
 User findByUserName(String userName);
}
