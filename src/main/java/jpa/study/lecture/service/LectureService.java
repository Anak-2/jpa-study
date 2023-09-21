package jpa.study.lecture.service;

import jpa.study.lecture.domain.Lecture;
import jpa.study.member.domain.Member;

import java.util.List;

public interface LectureService {

    Lecture saveLecture(Lecture lecture);

    List<Lecture> getLectures();

    Lecture findLectureByName(String name);

//    Member Domain
    List<Member> getMembers(Lecture lecture);

    void dropMember(Lecture lecture, Member member);
}
