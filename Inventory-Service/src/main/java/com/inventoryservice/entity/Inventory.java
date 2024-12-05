package com.inventoryservice.entity;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Inventory")
public class Inventory {
	@Transient
    public static final String SEQUENCE_NAME = "inventory_sequence";
	@Id
	private int inventoryId;
	@NotNull
	private String inventoryType;
	@NotNull
	@NotNull
	private String inventoryName;
	
	private String inventoryStock;

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getInventoryName() {
		return inventoryName;
	}

	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}

	public String getInventoryType() {
		return inventoryType;
	}

	public void setInventoryType(String inventoryType) {
		this.inventoryType = inventoryType;
	}

	public String getInventoryStock() {
		return inventoryStock;
	}

	public void setInventoryStock(String inventoryStock) {
		this.inventoryStock = inventoryStock;
	}

}
