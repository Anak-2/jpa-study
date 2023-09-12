package jpa.study.member.service;

import jpa.study.member.domain.Member;
import jpa.study.member.repository.MemberRepository;
import jpa.study.team.domain.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public Long saveMember(Member member) {
        Member savedMember = memberRepository.save(member);
        return savedMember.getId();
    }

    @Override
    public List<Member> getMembersByTeam(Team team) {
        return memberRepository.findMembersByTeam(team);
    }
}
