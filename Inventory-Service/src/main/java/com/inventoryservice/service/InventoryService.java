package com.inventoryservice.service;

import java.util.List;

import com.inventoryservice.entity.Inventory;
import com.inventoryservice.models.InventoryList;

public interface InventoryService {

	Inventory saveInventory(Inventory inventory);

	Inventory modifyInventory(Inventory inventory);

	String removeInventory(int id);

	Inventory getByInventoryId(int id);

	List<Inventory> getAllInventories();

}
