package me.goldze.mvvmhabit.http.entity;

public class ResponseThrowableEntity extends Exception {

    public int code;
    public String message;

    public ResponseThrowableEntity(Throwable throwable, int code) {
        super(throwable);
        this.code = code;
    }
}
