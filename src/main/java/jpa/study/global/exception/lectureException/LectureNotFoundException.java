package jpa.study.global.exception.lectureException;


public class LectureNotFoundException extends RuntimeException{

    public LectureNotFoundException() {
        super(LectureErrorMsg.LECTURE_NOT_FOUND.getMsg());
    }
}
