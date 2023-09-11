package jpa.study.jpa_study.service;

import jpa.study.member.domain.Member;
import jpa.study.member.service.MemberService;
import jpa.study.team.domain.Team;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Slf4j
public class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Test
    @DisplayName("멤버 등록")
    @Transactional
    void enroll_member(){
        //given
        Member member = Member.builder()
                .name("memberA")
                .team(new Team())
                .build();

        //when
        Long saved_id = memberService.saveMember(member);

        //then
        log.info("saved_id: {}",saved_id);

    }
}
