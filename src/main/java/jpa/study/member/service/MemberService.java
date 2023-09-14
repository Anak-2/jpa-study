package jpa.study.member.service;

import jpa.study.lecture.domain.Lecture;
import jpa.study.member.domain.Member;
import jpa.study.team.domain.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MemberService {
    Member saveMember(Member member);
    List<Member> getMembers();
    List<Member> getMembersByTeam(Team team);
    List<Lecture> getLecturesByMember(Member member);
}
