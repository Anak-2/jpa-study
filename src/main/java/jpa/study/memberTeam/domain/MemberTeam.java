package jpa.study.memberTeam.domain;

import jakarta.persistence.*;
import jpa.study.member.domain.Member;
import jpa.study.team.domain.Team;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberTeam {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name="member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name="team_id")
    private Team team;

    @DateTimeFormat
    private LocalDateTime enrollTime;

    @NonNull
    private Role memberRole;
}
