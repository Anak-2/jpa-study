package jpa.study.locker.service;

import jpa.study.locker.domain.Locker;
import jpa.study.member.domain.Member;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public interface LockerService {
    Locker allocateLocker(Member member, LocalDateTime expiration);
    Locker lookupLocker(Long memberId);
    void getBackLocker(Long memberId);
    void changeExpiration(Locker locker, LocalDateTime newExpiration);
}
