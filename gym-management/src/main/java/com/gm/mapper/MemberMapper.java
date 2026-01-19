package com.gm.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.gm.dto.request.CreateMemberRequest;
import com.gm.dto.response.MemberResponse;
import com.gm.entity.Member;

@Component
public class MemberMapper {
	
	public Member toEntity(CreateMemberRequest req) {
		Member member = new Member();
		member.setUsername(req.getUsername());
		member.setFirstName(req.getFirstName());
		member.setLastName(req.getLastName());
		member.setEmail(req.getEmail());
		member.setPhone(req.getPhone());
		member.setDateOfBirth(req.getDateOfBirth());
		member.setAddress(req.getAddress());
		member.setCreatedAt(LocalDateTime.now());
		member.setUpdatedAt(LocalDateTime.now());
		
		return member;
	}
	
	public MemberResponse toResponse(Member member) {
		return new MemberResponse(
					member.getId(),
					member.getUsername(),
					member.getFirstName(),
					member.getLastName(),
					member.getEmail(),
					member.getPhone(),
					member.getDateOfBirth(),
					member.getAddress(),
					member.getCreatedAt(),
					member.getUpdatedAt()
				);
	}

}
