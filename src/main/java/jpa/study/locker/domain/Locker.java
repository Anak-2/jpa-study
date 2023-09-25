package jpa.study.locker.domain;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import jpa.study.member.domain.Member;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.Duration;
import java.time.LocalDateTime;

// ToDo: maintain number of Locker as 30 and make locker available check when member requires
@Entity
@Getter
public class Locker {

    @Id
    @Column(name="locker_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Timestamp
    private LocalDateTime begin;

    @Timestamp
    private LocalDateTime expiration;

    public boolean validationExpiration(LocalDateTime expiration){
        return !expiration.isBefore(LocalDateTime.now());
    }

    public boolean updateExpiration(LocalDateTime expiration){
        if(!validationExpiration(expiration)) return false;
        this.expiration = expiration;
        return true;
    }

    public Locker() {
    }

    public Locker(Long id) {
        this.id = id;
    }

    @Builder
    public Locker(Member member, LocalDateTime begin, LocalDateTime expiration) {
        this.member = member;
        this.begin = begin;
        this.expiration = expiration;
    }
}
