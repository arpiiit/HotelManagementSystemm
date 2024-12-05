package com.receptionistservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.receptionistservice.entity.Guest;

public interface GuestRepository extends MongoRepository<Guest, Integer> 
{

}
