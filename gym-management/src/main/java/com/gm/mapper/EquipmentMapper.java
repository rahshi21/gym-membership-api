package com.gm.mapper;

import java.time.LocalDateTime;

import com.gm.dto.request.CreateEquipmentRequest;
import com.gm.entity.Equipment;
import com.gm.enums.EquipmentStatus;

public class EquipmentMapper {

    public static Equipment toEquipment(CreateEquipmentRequest request) {

        Equipment equipment = new Equipment();
        equipment.setEquipmentName(request.getEquipmentName());
        equipment.setTotalQuantity(request.getTotalQuantity());
        equipment.setAvailableQuantity(request.getTotalQuantity());
        equipment.setStatus(EquipmentStatus.WORKING);
        equipment.setCreatedAt(LocalDateTime.now());

        return equipment;
    }
}