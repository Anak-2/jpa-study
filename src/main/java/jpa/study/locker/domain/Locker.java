package jpa.study.locker.domain;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import jpa.study.member.domain.Member;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Locker {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="locker_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Timestamp
    private LocalDateTime begin;

    @Timestamp
    private LocalDateTime expiration;

    private boolean isEmpty;
}
