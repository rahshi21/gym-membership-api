package com.gm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gm.entity.EquipmentBooking;

@Repository
public interface EquipmentBookingRepository extends JpaRepository<EquipmentBooking, Long> {
}
