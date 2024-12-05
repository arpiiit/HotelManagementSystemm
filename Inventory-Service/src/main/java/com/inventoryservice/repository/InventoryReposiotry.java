package com.inventoryservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.inventoryservice.entity.Inventory;

public interface InventoryReposiotry extends MongoRepository<Inventory, Integer> 
{

}
