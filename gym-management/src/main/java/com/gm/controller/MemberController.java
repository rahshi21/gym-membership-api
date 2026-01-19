package com.gm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gm.config.CurrentUserUtil;
import com.gm.dto.request.CreateMemberRequest;
import com.gm.dto.request.PurchaseMembershipRequest;
import com.gm.dto.request.UpdateMemberRequest;
import com.gm.dto.response.MemberResponse;
import com.gm.dto.response.PaymentResponse;
import com.gm.entity.User;
import com.gm.service.MemberService;
import com.gm.service.MembershipPlanService;
import com.gm.service.PaymentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/member")
public class MemberController {
	
	@Autowired
	private CurrentUserUtil currentUserUtil;
	
	@Autowired
	private MemberService service;
	
	@Autowired
	private MemberService memberService;

    @Autowired
    private MembershipPlanService membershipPlanService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private RatingService ratingService;
	
	@GetMapping("/home")
	public String home(){
		User user = currentUserUtil.getUser();
		return "Welcome " + user.getUsername();
	}
	
	@PostMapping
	public ResponseEntity<MemberResponse> createMember(@Valid @RequestBody CreateMemberRequest request){
		MemberResponse response = service.createMember(request);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/profile")
	public ResponseEntity<MemberResponse> getMyProfile(){
		User user = currentUserUtil.getUser();
		return ResponseEntity.ok(service.getMyProfile(user));
	}
	
	@PutMapping("/profile")
    public MemberResponse updateProfile(@Valid @RequestBody UpdateMemberRequest request) {
        return memberService.updateProfile(request);
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<MemberResponse> getMember(@PathVariable Long id){
		return ResponseEntity.ok(service.getMemberById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<MemberResponse>> getAllMembers(){
		return ResponseEntity.ok(service.getAllMembers());
	}
	
	// ---------- MEMBERSHIP ----------

    @GetMapping("/membership")
    public ResponseEntity<?> viewMembershipPlans() {
        return membershipService.getActiveMemberships();
    }

    // ---------- EQUIPMENT BOOKING ----------

    @PostMapping("/equipment/booking")
    public ResponseEntity<?> bookEquipment(@Valid @RequestBody EquipmentBookingRequest request) {
        return bookingService.bookEquipment(request);
    }

    // ---------- PAYMENT ----------

    @PostMapping("/payment/{planId}")
    public ResponseEntity<PaymentResponse> purchaseMembership(
            @PathVariable Long planId,
            @RequestBody PurchaseMembershipRequest req) {
    	
    	PaymentResponse response = paymentService.purchaseMembership(planId, req.getMemberId());
		return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    // ---------- RATING ----------

    @PostMapping("/rating")
    public ResponseEntity<?> giveRating(@Valid @RequestBody RatingRequest request) {
        return ratingService.addRating(request);
    }

}

