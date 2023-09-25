package jpa.study.global.exception.lockerException;

import lombok.Getter;

@Getter
public enum LockerErrorMsg {

    LOCKER_EXPIRATION_ERROR("Locker Expiration Is Invalid");
    private final String msg;

    LockerErrorMsg(String msg){
        this.msg = msg;
    }
}
