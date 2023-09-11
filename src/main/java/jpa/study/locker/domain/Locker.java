package jpa.study.locker.domain;

import jakarta.persistence.*;
import jpa.study.member.domain.Member;
import lombok.Data;

@Entity
@Data
public class Locker {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    Member member;
}
