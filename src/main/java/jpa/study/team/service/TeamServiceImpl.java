package jpa.study.team.service;

import jpa.study.member.domain.Member;
import jpa.study.member.repository.MemberRepository;
import jpa.study.team.domain.Team;
import jpa.study.team.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService{

    private final TeamRepository teamRepository;
    private final MemberRepository memberRepository;

    @Override
    public List<Member> getMembers(Team team) {
        return memberRepository.findMembersByTeam(team);
    }
}
