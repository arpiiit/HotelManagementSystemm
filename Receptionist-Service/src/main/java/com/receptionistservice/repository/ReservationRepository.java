package com.receptionistservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.receptionistservice.entity.Reservation;

public interface ReservationRepository extends MongoRepository<Reservation,Integer> 
{

}
