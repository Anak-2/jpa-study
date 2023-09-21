package jpa.study.memberLecture;

import jpa.study.lecture.domain.Lecture;
import jpa.study.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MemberLectureRepository extends JpaRepository<MemberLecture, Long> {

    @Query("select ml.member from MemberLecture ml where ml.lecture = (:lecture)")
    List<Member> findMembersByLecture(
            @Param("lecture")
            Lecture lecture
    );

    @Query("select ml.lecture from MemberLecture ml where ml.member = (:member)")
    List<Lecture> findLecturesByMember(
            @Param("member")
            Member member
    );

    @Modifying
    @Query("delete from MemberLecture ml where ml.member = (:member) and ml.lecture = (:lecture)")
    void dropMemberOrLecture(
            @Param("lecture")
            Lecture lecture,
            @Param("member")
            Member member
    );

}
