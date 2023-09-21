package jpa.study.lecture.service;

import jpa.study.global.exception.lectureException.LectureNotFoundException;
import jpa.study.lecture.domain.Lecture;
import jpa.study.lecture.repsitory.LectureRepository;
import jpa.study.member.domain.Member;
import jpa.study.memberLecture.MemberLectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class LectureServiceImpl implements LectureService{

    private final LectureRepository lectureRepository;
    private final MemberLectureRepository memberLectureRepository;

    @Override
    public List<Member> getMembers(Lecture lecture) {
        return memberLectureRepository.findMembersByLecture(lecture);
    }

    @Override
    public void dropMember(Lecture lecture, Member member) {
        memberLectureRepository.dropMemberOrLecture(lecture, member);
    }

    @Override
    public Lecture saveLecture(Lecture lecture) {
        return lectureRepository.save(lecture);
    }

    @Override
    public List<Lecture> getLectures() {
        return lectureRepository.findAll();
    }

    @Override
    public Lecture findLectureByName(String name) {
        return lectureRepository.findLectureByName(name).orElseThrow(LectureNotFoundException::new);
    }
}
