package com.gm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gm.dto.request.AddEquipmentStockRequest;
import com.gm.dto.request.CreateEquipmentRequest;
import com.gm.dto.request.CreateMembershipPlanRequest;
import com.gm.dto.request.UpdateEquipmentStatusRequest;
import com.gm.dto.request.UpdateMembershipPlanRequest;
import com.gm.dto.response.MemberResponse;
import com.gm.dto.response.MembershipPlanResponse;
import com.gm.service.EquipmentService;
import com.gm.service.MemberService;
import com.gm.service.MembershipPlanService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	private MembershipPlanService membershipPlanService;

	@Autowired
	private EquipmentService equipmentService;

	@Autowired
	private MemberService memberService;

	@Autowired
	private TrainerService trainerService;

	//MEMBERSHIP

	@PostMapping("/membership")
	public MembershipPlanResponse addMembership(@Valid @RequestBody CreateMembershipPlanRequest request) {
		return membershipPlanService.addMembership(request);
	}

	@PutMapping("/membership")
	public MembershipPlanResponse updateMembership(@Valid @RequestBody UpdateMembershipPlanRequest request) {
		return membershipPlanService.updateMembership(request);
	}

	@GetMapping("/membership/{id}")
	public ResponseEntity<MembershipPlanResponse> getMembershipById(@PathVariable Long id) {
		return ResponseEntity.ok(membershipPlanService.getMembershipById(id));
	}
	
	@GetMapping("/membership")
	public List<MembershipPlanResponse> getAllMemberships() {
		return membershipPlanService.getAllMemberships();
	}

	// EQUIPMENT

	@PostMapping("/equipment/add")
	public ResponseEntity<?> createEquipment(@Valid @RequestBody CreateEquipmentRequest request) {
		return equipmentService.createEquipment(request);
	}
	
	@PostMapping("/equipment/add-stock")
	public ResponseEntity<?> addEquipmentStock(@Valid @RequestBody AddEquipmentStockRequest request) {
		return equipmentService.addEquipmentStock(request);
	}

	@PutMapping("/equipment/status")
	public ResponseEntity<?> updateEquipmentStatus(@Valid @RequestBody UpdateEquipmentStatusRequest request) {
		return equipmentService.updateEquipmentStatus(request);
	}

	@GetMapping("/equipments")
	public ResponseEntity<?> getAllEquipment() {
		return equipmentService.getAllEquipment();
	}

	// ---------- CUSTOMERS ----------

	@GetMapping("/members")
	public List<MemberResponse> getAllMembers() {
		return memberService.getAllMembers();
	}

	// ---------- TRAINERS ----------

	@PostMapping("/trainers")
	public ResponseEntity<?> addTrainer(@Valid @RequestBody AddTrainerRequest request) {
		return trainerService.AddTrainerRequest(request);
	}

	@PutMapping("/trainers")
	public ResponseEntity<?> updateTrainer(@Valid @RequestBody UpdateTrainerRequest request) {
		return trainerService.updateTrainer(request);
	}
	
	@GetMapping("/trainers")
	public ResponseEntity<?> getAllTrainers() {
		return trainerService.getAllTrainers();
	}
}
