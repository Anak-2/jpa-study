package jpa.study.lecture.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Getter
public class Lecture {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="lecture_id")
    private Long id;

    private String name;

    @DateTimeFormat
    private LocalDateTime lecture_start;

    @DateTimeFormat
    private LocalDateTime lecture_end;

    protected Lecture(){
    }

    @Builder
    public Lecture(String name, LocalDateTime lecture_start, LocalDateTime lecture_end) {
        this.name = name;
        this.lecture_start = lecture_start;
        this.lecture_end = lecture_end;
    }
}
