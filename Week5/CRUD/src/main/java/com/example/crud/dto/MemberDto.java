package com.example.crud.dto;

import com.example.crud.domain.Member;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MemberDto {
    private Long id;
    private String name;
    private String email;
    private LocalDateTime registerDate;


    public static MemberDto from(Member member) {
        MemberDto memberDto = new MemberDto();
        memberDto.setId(member.getId());
        memberDto.setName(member.getName());
        memberDto.setEmail(member.getEmail());
        memberDto.setRegisterDate(member.getRegisterDate());
        return memberDto;
    }
}