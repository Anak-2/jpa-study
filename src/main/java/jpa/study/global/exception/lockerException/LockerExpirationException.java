package jpa.study.global.exception.lockerException;

public class LockerExpirationException extends RuntimeException{

    public LockerExpirationException() {
        super(LockerErrorMsg.LOCKER_EXPIRATION_ERROR.getMsg());
    }
}
