package jpa.study.lecture.service;

import jpa.study.lecture.domain.Lecture;
import jpa.study.member.domain.Member;

import java.util.List;

public interface LectureService {

    List<Member> getMembers(Lecture lecture);

    Lecture saveLecture(Lecture lecture);
}
