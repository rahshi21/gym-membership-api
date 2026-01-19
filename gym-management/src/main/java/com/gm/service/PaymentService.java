package com.gm.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gm.dto.response.PaymentResponse;
import com.gm.entity.MembershipPlan;
import com.gm.entity.Payment;
import com.gm.enums.PaymentStatus;
import com.gm.exception.MembershipPlanNotFoundException;
import com.gm.repository.MembershipPlanRepository;
import com.gm.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepo;

	@Autowired
	private MembershipPlanRepository planRepo;

	public PaymentResponse purchaseMembership(Long planId, Long memberId) {

		MembershipPlan plan = planRepo.findById(planId).orElseThrow(
				() -> new MembershipPlanNotFoundException("Plan with id : "+planId+"not found")
				);

		// Create payment (PENDING)
		Payment payment = new Payment();
		payment.setMemberId(memberId);
		payment.setMembershipPlanId(planId);
		payment.setAmount(plan.getPrice());
		payment.setStatus(PaymentStatus.PENDING);

		paymentRepo.save(payment);

		// Simulate successful payment
		payment.setStatus(PaymentStatus.PAID);
		payment.setPaymentDate(LocalDateTime.now());

		paymentRepo.save(payment);

		return new PaymentResponse(
				payment.getId(), 
				payment.getMemberId(),
				payment.getMembershipPlanId(),
				payment.getAmount(), 
				payment.getStatus(),
				payment.getPaymentDate()
				);
	}

}
