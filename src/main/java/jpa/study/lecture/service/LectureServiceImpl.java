package jpa.study.lecture.service;

import jpa.study.lecture.domain.Lecture;
import jpa.study.lecture.repsitory.LectureRepository;
import jpa.study.member.domain.Member;
import jpa.study.memberLecture.MemberLectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LectureServiceImpl implements LectureService{

    private final LectureRepository lectureRepository;
    private final MemberLectureRepository memberLectureRepository;

    @Override
    public List<Member> getMembers(Lecture lecture) {
        return memberLectureRepository.findMembersByLecture(lecture);
    }

    @Override
    public Lecture saveLecture(Lecture lecture) {
        return lectureRepository.save(lecture);
    }
}
