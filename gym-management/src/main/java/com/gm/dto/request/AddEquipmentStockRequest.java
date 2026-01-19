package com.gm.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;

public class AddEquipmentStockRequest {

	@Min(value = 1, message = "Equipment ID must be valid")
	private Long equipmentId;

	@Positive(message = "Quantity must be greater than zero")
	private Integer quantity;

	public Long getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(Long equipmentId) {
		this.equipmentId = equipmentId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
}
