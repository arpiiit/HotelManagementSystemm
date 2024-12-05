package com.ownerservice.service;

import java.util.List;

import com.ownerservice.models.Owner;

public interface OwnerService {
	
	Owner addOwner(Owner owner);

	List<Owner> getAllOwners();
	
	
}
