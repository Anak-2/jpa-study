package jpa.study;

import jakarta.annotation.PostConstruct;
import jpa.study.lecture.domain.Lecture;
import jpa.study.lecture.service.LectureService;
import jpa.study.member.domain.Member;
import jpa.study.member.service.MemberService;
import jpa.study.memberLecture.MemberLecture;
import jpa.study.memberLecture.MemberLectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Component
public class TestInitializer {

    private final MemberService memberService;
    private final LectureService lectureService;
    private final MemberLectureRepository memberLectureRepository;

    @PostConstruct
    public void init(){

        String[] lectureNames = new String[]{"소프트웨어공학","시스템프로그래밍","웹시스템설계"};
        List<Lecture> lectures = new ArrayList<>();
        Arrays.stream(lectureNames).forEach(name -> {
            Lecture temp = makeLecture(name);
            lectures.add(temp);
            lectureService.saveLecture(temp);
        });

        Member member1 = makeMember("member1");
        memberService.saveMember(member1);

        lectures.stream().forEach(lecture -> {
            memberLectureRepository.save(makeMemberLecture(member1, lecture));
        });
    }

    Lecture makeLecture(String lectureName){
        return Lecture.builder()
                .name(lectureName)
                .build();
    }

    Member makeMember(String name){
        return Member.builder()
                .name(name)
                .build();
    }

    MemberLecture makeMemberLecture(Member member, Lecture lecture){
        return MemberLecture.builder()
                .member(member)
                .lecture(lecture)
                .build();
    }
}
