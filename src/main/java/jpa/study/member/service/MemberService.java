package jpa.study.member.service;

import jpa.study.member.domain.Member;
import jpa.study.team.domain.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MemberService {
    Long saveMember(Member member);
    List<Member> getMembersByTeam(Team team);
}
