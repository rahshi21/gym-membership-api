package com.gm.dto.request;

import jakarta.validation.constraints.NotNull;

public class PurchaseMembershipRequest {
	
	@NotNull(message = "Member ID is required")
	private Long memberId;

	public PurchaseMembershipRequest() {
		super();
	}

	public PurchaseMembershipRequest(Long memberId) {
		super();
		this.memberId = memberId;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	
	
	

}
