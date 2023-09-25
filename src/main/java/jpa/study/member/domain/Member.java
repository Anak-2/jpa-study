package jpa.study.member.domain;

import jakarta.persistence.*;
import jpa.study.team.domain.Team;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="team_id")
    private Team team;


    @CreationTimestamp
    private LocalDateTime createTime;

    protected Member() {
    }

    @Builder
    private Member(String name, Team team, LocalDateTime createTime) {
        this.name = name;
        this.team = team;
        this.createTime = createTime;
    }
}
