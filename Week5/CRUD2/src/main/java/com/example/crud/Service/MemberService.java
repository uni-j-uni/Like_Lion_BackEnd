package com.example.crud.Service;

import com.example.crud.Repository.MemberRepository;
import com.example.crud.domain.Member;
import com.example.crud.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    @Transactional // Create
    public Member registerMember(Member member) {
        return memberRepository.save(member);
    }
    @Transactional // Delete
    public void deleteMember(Long id) { memberRepository.deleteById(id); }
    @Transactional // Update
    public Member updateMember(Long id, MemberDto memberDto) {
        Optional<Member> memberOptional = memberRepository.findById(id);
        if (memberOptional.isPresent()) {
            Member member = memberOptional.get();
            if (memberDto.getName() != null) member.setName(memberDto.getName());
            if (memberDto.getEmail() != null) member.setEmail(memberDto.getEmail());
            return memberRepository.save(member);
        }
        else throw new RuntimeException("Member not found with id " + id);
    }
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    } // Read
    public Optional<Member> getMemberById(Long id) {
        return memberRepository.findById(id);
    } //Read
}