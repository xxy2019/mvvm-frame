package me.goldze.mvvmhabit.http.entity;

/**
 * 该类仅供参考，实际业务返回的固定字段, 根据需求来定义，
 */
public class BaseResponseEntity<T> {
    private int code;
    private String message;
    private T data;

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isOk() {
        return code == 200;
    }
}
