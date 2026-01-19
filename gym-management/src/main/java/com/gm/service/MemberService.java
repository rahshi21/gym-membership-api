package com.gm.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gm.dto.request.CreateMemberRequest;
import com.gm.dto.request.UpdateMemberRequest;
import com.gm.dto.response.MemberResponse;
import com.gm.entity.Member;
import com.gm.entity.User;
import com.gm.exception.MemberNotFoundException;
import com.gm.mapper.MemberMapper;
import com.gm.repository.MemberRepository;

@Service
public class MemberService {
	
	Logger logger = LoggerFactory.getLogger(MemberService.class);
	
	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private MemberMapper mapper;
	
	public MemberResponse createMember(CreateMemberRequest request) {
		Member member = mapper.toEntity(request);
		Member saved = memberRepo.save(member);
		MemberResponse response = mapper.toResponse(saved);
		return response;
	}
	
	public MemberResponse updateProfile(UpdateMemberRequest request) {
		Member member = memberRepo.findById(request.getId()).orElseThrow(
				() -> new MemberNotFoundException("This member id does not exist"));

		member.setEmail(request.getEmail());
		member.setPhone(request.getPhone());
		member.setAddress(request.getAddress());
		

		Member saved = memberRepo.save(member);
		logger.info(saved.toString());
		MemberResponse response = mapper.toResponse(saved);

		return response;
	}
	
	public MemberResponse getMyProfile(User user) {
		logger.info("username : " + user.getUsername());
		Member member = memberRepo.findByUsername(user.getUsername())
				.orElseThrow(() ->
						new MemberNotFoundException("Member not found : " + user.getUsername())
						);
		
		MemberResponse response = mapper.toResponse(member);
		return response;
	}
	
	public MemberResponse getMemberById(Long id) {
		logger.info("Get Member by id : " + id);
		Member member = memberRepo.findById(id).orElseThrow(
					() -> new RuntimeException("Member not found")
				);
		MemberResponse response = mapper.toResponse(member);
		return response;
	}

	public List<MemberResponse> getAllMembers() {
		return memberRepo.findAll()
				.stream()
				.map(mapper::toResponse)
				.collect(Collectors.toList());
	}
	

}
