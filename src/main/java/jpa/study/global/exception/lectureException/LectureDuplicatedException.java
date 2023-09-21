package jpa.study.global.exception.lectureException;

import lombok.Getter;

@Getter
public class LectureDuplicatedException extends RuntimeException{
    public LectureDuplicatedException() {
        super();
    }
}
