package jpa.study.team.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

// Team is similar with School Club
@Entity
@Getter
public class Team {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="team_id")
    private Long id;

    String name;

    protected Team() {
    }

    @Builder
    private Team(String name) {
        this.name = name;
    }
}
