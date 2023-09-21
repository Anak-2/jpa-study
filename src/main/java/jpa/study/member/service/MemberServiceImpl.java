package jpa.study.member.service;

import jpa.study.global.exception.lectureException.LectureDuplicatedException;
import jpa.study.lecture.domain.Lecture;
import jpa.study.locker.domain.Locker;
import jpa.study.member.domain.Member;
import jpa.study.member.repository.MemberRepository;
import jpa.study.memberLecture.MemberLecture;
import jpa.study.memberLecture.MemberLectureRepository;
import jpa.study.team.domain.Team;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final MemberLectureRepository memberLectureRepository;

    @Override
    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    @Override
    public List<Member> getMembersByTeam(Team team) {
        return memberRepository.findMembersByTeam(team);
    }

//    Lecture Logic

    @Override
    public List<Lecture> getLecturesByMember(Member member) {
        return memberLectureRepository.findLecturesByMember(member);
    }

    @Override
    public void enrollLecture(@NonNull Lecture lecture, @NonNull Member member) {
        List<Lecture> lectures = memberLectureRepository.findLecturesByMember(member);
        lectures.forEach(l -> {
            if (Objects.equals(l.getId(), lecture.getId())) throw new LectureDuplicatedException();
        });
        memberLectureRepository.save(MemberLecture.builder()
                .lecture(lecture)
                .member(member)
                .build());
    }

    @Override
    public void dropLecture(@NonNull Lecture lecture, @NonNull Member member) {
        memberLectureRepository.dropMemberOrLecture(lecture, member);
    }

//    Team Logic

    @Override
    public void joinTeam(Team team) {

    }

    @Override
    public void leaveTeam(Team team) {

    }

//    Locker Logic

    @Override
    public void occupyLocker(Locker locker) {

    }

    @Override
    public void returnLocker(Locker locker) {

    }
}
