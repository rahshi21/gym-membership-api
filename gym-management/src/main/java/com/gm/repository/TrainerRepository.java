package com.gm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gm.entity.Equipment;
import com.gm.entity.Trainer;
import com.gm.enums.EquipmentStatus;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {

	List<Equipment> findByStatus(EquipmentStatus status);
}
