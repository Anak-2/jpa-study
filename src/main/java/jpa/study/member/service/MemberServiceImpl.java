package jpa.study.member.service;

import jpa.study.lecture.domain.Lecture;
import jpa.study.member.domain.Member;
import jpa.study.member.repository.MemberRepository;
import jpa.study.memberLecture.MemberLectureRepository;
import jpa.study.team.domain.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService{

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

    @Override
    public List<Lecture> getLecturesByMember(Member member) {
        return memberLectureRepository.findLecturesByMember(member);
    }
}
