package jpa.study.locker.domain;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import jpa.study.member.domain.Member;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Locker {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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
