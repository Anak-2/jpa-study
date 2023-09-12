package jpa.study.jpa_study.service;

import jakarta.persistence.EntityManager;
import jpa.study.member.domain.Member;
import jpa.study.member.repository.MemberRepository;
import jpa.study.team.domain.Team;
import jpa.study.team.repository.TeamRepository;
import jpa.study.team.service.TeamService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TeamServiceTest {

    @Autowired
    EntityManager em;
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    TeamService teamService;

    @Test
    @Transactional
    void get_members_by_team(){
        //given
        Team team = Team.builder()
                .name("team1")
                .build();
        List<Member> memberList = make_mock_members(team);
        teamRepository.save(team);
        memberRepository.saveAll(memberList);
        //when
        List<Member> findMembers = teamService.getMembers(team);
        //then
        findMembers.forEach(System.out::println);
    }

    List<Member> make_mock_members(Team team){
        List<Member> memberList = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            memberList.add(Member.builder()
                            .team(team)

                            .build());
        }
        return memberList;
    }
}
