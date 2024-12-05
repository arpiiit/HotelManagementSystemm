package com.inventoryservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventoryservice.entity.Inventory;
import com.inventoryservice.exception.InventoryNotFoundWithIdException;
import com.inventoryservice.models.InventoryList;
import com.inventoryservice.repository.InventoryReposiotry;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryReposiotry inventoryReposiotry;
	

	@Autowired
	private SequenceGeneratorService seqService;


	@Override
	public Inventory saveInventory(Inventory inventory) {
		// TODO Auto-generated method stub
		inventory.setInventoryId(seqService.getSequenceNumber(Inventory.SEQUENCE_NAME));
		return inventoryReposiotry.save(inventory);
	}

	@Override
	public Inventory modifyInventory(Inventory inventory) {
		// TODO Auto-generated method stub
		Optional<Inventory> foundInventory = inventoryReposiotry.findById(inventory.getInventoryId());
		if (foundInventory.isEmpty()) {
			throw new InventoryNotFoundWithIdException("Inventory Not Found with ID " + inventory.getInventoryId());
		}
		return inventoryReposiotry.save(inventory);
	}

	@Override
	public String removeInventory(int id) {
		// TODO Auto-generated method stub
		Optional<Inventory> inventory = inventoryReposiotry.findById(id);
		if (inventory.isEmpty()) {
			throw new InventoryNotFoundWithIdException("Inventory Not Found With ID " + id);
		}
		inventoryReposiotry.deleteById(id);
		return "Inventory deleted successfully with ID " + id;
	}

	@Override
	public Inventory getByInventoryId(int id) {
		// TODO Auto-generated method stub
		Optional<Inventory> inventory = inventoryReposiotry.findById(id);
		if (inventory.isEmpty()) {
			throw new InventoryNotFoundWithIdException("Inventory Not Found With ID " + id);
		}
		return inventory.get();
	}

	@Override
	public List<Inventory> getAllInventories() {
		// TODO Auto-generated method stub
		
		return inventoryReposiotry.findAll();
	}

}
