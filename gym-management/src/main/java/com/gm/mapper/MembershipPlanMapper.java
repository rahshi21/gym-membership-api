package com.gm.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.gm.dto.request.CreateMembershipPlanRequest;
import com.gm.dto.response.MembershipPlanResponse;
import com.gm.entity.MembershipPlan;

@Component
public class MembershipPlanMapper {
	
	public MembershipPlan toEntity(CreateMembershipPlanRequest req) {
		MembershipPlan plan = new MembershipPlan();
		plan.setMembershipLevel(req.getMembershipLevel());
		plan.setDurationOfMembershipPlan(req.getDurationOfMembershipPlan());
		plan.setGoal(req.getGoal());
		plan.setPrice(req.getPrice());
		plan.setDescription(req.getDescription());
		plan.setActive(req.getActive());
		plan.setCreatedAt(LocalDateTime.now());
		plan.setUpdatedAt(LocalDateTime.now());
		
		return plan;
	}
	
	public MembershipPlanResponse toResponse(MembershipPlan plan) {
		return new MembershipPlanResponse(
					plan.getId(),
					plan.getMembershipLevel(),
					plan.getDurationOfMembershipPlan(),
					plan.getGoal(),
					plan.getPrice(),
					plan.getDescription(),
					plan.getActive(),
					plan.getCreatedAt(),
					plan.getUpdatedAt()
				);
	}

}
