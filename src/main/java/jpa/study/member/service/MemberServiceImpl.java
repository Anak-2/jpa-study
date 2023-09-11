package jpa.study.member.service;

import jpa.study.member.domain.Member;
import jpa.study.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public Long saveMember(Member member) {
        Member savedMember = memberRepository.save(member);
        return savedMember.getId();
    }
}
