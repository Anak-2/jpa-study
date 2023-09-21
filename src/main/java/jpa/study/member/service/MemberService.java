package jpa.study.member.service;

import jpa.study.lecture.domain.Lecture;
import jpa.study.locker.domain.Locker;
import jpa.study.member.domain.Member;
import jpa.study.team.domain.Team;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MemberService {
    Member saveMember(Member member);
    List<Member> getMembers();
    List<Member> getMembersByTeam(Team team);
    List<Lecture> getLecturesByMember(Member member);
    void enrollLecture(Lecture lecture, Member member);
    void dropLecture(Lecture lecture, Member member);
    void joinTeam(Team team);
    void leaveTeam(Team team);
    void occupyLocker(Locker locker);
    void returnLocker(Locker locker);
}
