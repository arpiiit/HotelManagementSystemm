package com.receptionistservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.receptionistservice.entity.Receptionist;
import com.receptionistservice.models.User;

public interface ReceptionistRepository extends MongoRepository<Receptionist, Integer>
{
 User findByUserName(String userName);
}
