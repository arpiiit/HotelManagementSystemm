package com.inventoryservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventoryservice.entity.Inventory;
import com.inventoryservice.models.InventoryList;
import com.inventoryservice.service.InventoryServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/inventory")
public class InventoryController {

	@Autowired
	private InventoryServiceImpl inventoryServiceImpl;

	@PostMapping("/add")
	public ResponseEntity<Inventory> addInventory(@RequestBody Inventory inventory) {
		Inventory savedInventory = inventoryServiceImpl.saveInventory(inventory);
		return new ResponseEntity<>(savedInventory, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Inventory> updateInventory(@RequestBody Inventory inventory) {
		Inventory updatedInventory = inventoryServiceImpl.modifyInventory(inventory);
		return new ResponseEntity<>(updatedInventory, HttpStatus.OK);
	}

	@GetMapping("/find/{inventoryId}")
	public ResponseEntity<Inventory> fetchByInventoryId(@PathVariable("inventoryId") int id) {
		Inventory inventory = inventoryServiceImpl.getByInventoryId(id);
		return new ResponseEntity<>(inventory, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{inventoryId}")
	public ResponseEntity<String> deleteInventory(@PathVariable("inventoryId") int id) {
		String msg = inventoryServiceImpl.removeInventory(id);
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Inventory>> fetchAllInventories() {
		List<Inventory> list = inventoryServiceImpl.getAllInventories();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
