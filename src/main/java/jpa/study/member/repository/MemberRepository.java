package jpa.study.member.repository;

import jpa.study.member.domain.Member;
import jpa.study.team.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findMembersByTeam(Team team);
}
