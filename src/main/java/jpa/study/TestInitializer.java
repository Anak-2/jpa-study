package jpa.study;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jpa.study.lecture.domain.Lecture;
import jpa.study.lecture.service.LectureService;
import jpa.study.locker.domain.Locker;
import jpa.study.locker.repository.LockerRepository;
import jpa.study.member.domain.Member;
import jpa.study.member.service.MemberService;
import jpa.study.memberLecture.MemberLecture;
import jpa.study.memberLecture.MemberLectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RequiredArgsConstructor
@Component
public class TestInitializer {

    public static final int MAX_LOCKER = 30;

    private final MemberService memberService;
    private final LectureService lectureService;
    private final LockerRepository lockerRepository;
    private final MemberLectureRepository memberLectureRepository;
    private final EntityManager em;

    @PostConstruct
    public void init(){
        // init locker
        initLocker();

        String[] lectureNames = new String[]{"소프트웨어공학","시스템프로그래밍","웹시스템설계"};
        List<Lecture> lectures = new ArrayList<>();
        Arrays.stream(lectureNames).forEach(name -> {
            Lecture temp = makeLecture(name);
            lectures.add(temp);
            lectureService.saveLecture(temp);
        });

        Member member1 = makeMember("member1");
        memberService.saveMember(member1);

        lectures.forEach(lecture -> {
            memberLectureRepository.save(makeMemberLecture(member1, lecture));
        });
    }

    private Lecture makeLecture(String lectureName){
        return Lecture.builder()
                .name(lectureName)
                .build();
    }

    private Member makeMember(String name){
        return Member.builder()
                .name(name)
                .build();
    }

    private MemberLecture makeMemberLecture(Member member, Lecture lecture){
        return MemberLecture.builder()
                .member(member)
                .lecture(lecture)
                .build();
    }

    // make 30 Locker
    private void initLocker(){
        for(long i = 1L; i <= MAX_LOCKER; i++){
            lockerRepository.save(new Locker(i));
        }
    }
}
