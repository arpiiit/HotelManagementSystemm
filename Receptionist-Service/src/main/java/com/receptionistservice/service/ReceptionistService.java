package com.receptionistservice.service;

import java.util.List;

import com.receptionistservice.entity.Receptionist;

public interface ReceptionistService {
	Receptionist addReceptionist(Receptionist receptionist);

	List<Receptionist> getAllReceptionists();
}
