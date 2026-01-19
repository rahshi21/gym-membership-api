package com.gm.dto.request;

import com.gm.enums.EquipmentStatus;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class UpdateEquipmentStatusRequest {

	@Min(value = 1, message = "Equipment ID must be valid")
    private Long equipmentId;

    @NotNull(message = "Status is mandatory")
    private EquipmentStatus status;

	public Long getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(Long equipmentId) {
		this.equipmentId = equipmentId;
	}

	public EquipmentStatus getStatus() {
		return status;
	}

	public void setStatus(EquipmentStatus status) {
		this.status = status;
	}


    
}
