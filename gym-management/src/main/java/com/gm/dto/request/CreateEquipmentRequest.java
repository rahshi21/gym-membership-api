package com.gm.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class CreateEquipmentRequest {
	
	@NotBlank(message = "Equipment name is mandatory")
    private String equipmentName;

    @Positive(message = "Total quantity must be greater than zero")
    private Integer totalQuantity;

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public Integer getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(Integer totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

}
