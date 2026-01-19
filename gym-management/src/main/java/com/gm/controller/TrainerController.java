package com.gm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/trainer")
public class TrainerController {

    @Autowired
    private TrainerService trainerService;

    @Autowired
    private DietPlanService dietPlanService;

    // ---------- PROFILE ----------
    
    @PostMapping("/profile")
	public ResponseEntity<?> addTrainer(@Valid @RequestBody AddTrainerRequest request) {
		return trainerService.AddTrainerRequest(request);
	}

	@PutMapping("/profile")
	public ResponseEntity<?> updateTrainer(@Valid @RequestBody UpdateTrainerRequest request) {
		return trainerService.updateTrainer(request);
	}

    @GetMapping("/profile/{id}")
    public ResponseEntity<?> getTrainerProfile(@PathVariable Long id) {
        return trainerService.getTrainerById(id);
    }

    // ---------- CUSTOMERS ----------

    @GetMapping("/customers/{trainerId}")
    public ResponseEntity<?> getAssignedCustomers(@PathVariable Long trainerId) {
        return trainerService.getAssignedCustomers(trainerId);
    }

    // ---------- DIET PLAN ----------

    @PostMapping("/diet-plan")
    public ResponseEntity<?> createDietPlan(@Valid @RequestBody AddDietPlanRequest request) {
        return dietPlanService.addDietPlan(request);
    }

    @PutMapping("/diet-plan")
    public ResponseEntity<?> updateDietPlan(@Valid @RequestBody AddDietPlanRequest request) {
        return dietPlanService.updateDietPlan(request);
    }
}
