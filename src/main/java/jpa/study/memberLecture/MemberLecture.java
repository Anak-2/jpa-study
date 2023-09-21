package jpa.study.memberLecture;

import jakarta.persistence.*;
import jpa.study.lecture.domain.Lecture;
import jpa.study.member.domain.Member;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberLecture {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    @NonNull
    private Member member;

    @ManyToOne
    @JoinColumn(name = "lecture_id")
    @NonNull
    private Lecture lecture;

}
