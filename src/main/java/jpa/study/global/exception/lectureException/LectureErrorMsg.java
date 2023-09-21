package jpa.study.global.exception.lectureException;

import lombok.Getter;

@Getter
public enum LectureErrorMsg {
    LECTURE_NOT_FOUND("No Such Lecture Found"),
    LECTURE_DUPLICATED("Lecture already exists");

    private final String msg;

    LectureErrorMsg(String msg){
        this.msg = msg;
    }
}
