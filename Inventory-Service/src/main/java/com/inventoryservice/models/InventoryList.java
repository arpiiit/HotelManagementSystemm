package com.inventoryservice.models;

import java.util.List;

import com.inventoryservice.entity.Inventory;

public class InventoryList {
	
	private List<Inventory> listOfInventories;

	public List<Inventory> getListOfInventories() {
		return listOfInventories;
	}

	public void setListOfInventories(List<Inventory> listOfInventories) {
		this.listOfInventories = listOfInventories;
	}
	

}
