package jpa.study.jpa_study.service;

import jakarta.persistence.EntityManager;
import jpa.study.TestInitializer;
import jpa.study.lecture.domain.Lecture;
import jpa.study.member.domain.Member;
import jpa.study.member.service.MemberService;
import jpa.study.lecture.service.LectureService;
import jpa.study.memberLecture.MemberLectureRepository;
import jpa.study.team.domain.Team;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Slf4j
public class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    LectureService lectureService;
    @Autowired
    MemberLectureRepository memberLectureRepository;
    @Autowired
    TestInitializer testInitializer;
    @Autowired
    EntityManager em;

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
        Member saved_member = memberService.saveMember(member);

        //then
        log.info("saved_member: {}",saved_member);

    }

    @Test
    @DisplayName("참여 강의 확인")
    @Transactional
    void find_lectures(){
        //given
//        testInitializer.init();
        Member member = memberService.getMembers().get(0);
        //when
        List<Lecture> lectures = memberService.getLecturesByMember(member);
        //then
        log.info("lecture count: {}",lectures.size());
        lectures.forEach(System.out::println);
    }

    @Test
    @DisplayName("멤버의 수강 목록 조회, 수강 취소")
    @Transactional
    void drop_lecture(){
        //given
//        testInitializer.init();
        Member member = memberService.getMembers().get(0);
        Lecture lecture = lectureService.getLectures().get(0);
        List<Lecture> lectures = memberService.getLecturesByMember(member);
        System.out.println("***** 출력 *****");
        lectures.forEach(l -> {
            log.info(l.getName());
        });
        //when
        memberService.dropLecture(lecture, member);
        //then
        Assertions.assertEquals(memberService.getLecturesByMember(member).size(),2);
    }
}
