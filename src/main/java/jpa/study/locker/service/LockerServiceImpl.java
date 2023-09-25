package jpa.study.locker.service;

import jpa.study.global.exception.lockerException.LockerExpirationException;
import jpa.study.locker.domain.Locker;
import jpa.study.locker.repository.LockerRepository;
import jpa.study.member.domain.Member;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class LockerServiceImpl implements LockerService{

    private final LockerRepository lockerRepository;

    @Override
    public Locker allocateLocker(Member member, LocalDateTime expiration) {
        //Todo: Check Available Locker Validation
        return lockerRepository.save(Locker.builder()
                .begin(LocalDateTime.now())
                .expiration(expiration)
                .member(member)
                .build());
    }

    @Override
    public Locker lookupLocker(Long memberId) {
        return lockerRepository.findLockerByMember_Id(memberId);
    }

    @Override
    public void getBackLocker(Long memberId) {
        lockerRepository.deleteLockerByMember_Id(memberId);
    }

    @Override
    public void changeExpiration(Locker locker, LocalDateTime newExpiration) {
        if(!locker.updateExpiration(newExpiration)) throw new LockerExpirationException();
    }
}
