package jpa.study.locker.repository;

import jpa.study.locker.domain.Locker;
import jpa.study.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LockerRepository extends JpaRepository<Locker, Long> {
    Locker findLockerByMember_Id(Long memberId);
    void deleteLockerByMember_Id(Long memberId);
}
