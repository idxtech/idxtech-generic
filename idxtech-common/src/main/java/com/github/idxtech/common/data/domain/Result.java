package com.github.idxtech.common.data.domain;

import java.io.Serializable;

public class Result<T> implements Serializable {

    private static final long serialVersionUID = -6706669923646665614L;

    private int code;

    private String message;

    private T data;

    public Result() {
    }

    public Result(T data) {
        this.data = data;
    }

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> succeed() {
        return new Result<>();
    }

    public static <T> Result<T> succeed(T data) {
        return new Result<>(data);
    }

    public static <T> Result<T> succeed(String message) {
        return new Result<>(0, message);
    }

    public static <T> Result<T> succeed(String message, T data) {
        return new Result<>(0, message, data);
    }

    public static <T> Result<T> fail(int code, String message) {
        return new Result<>(code, message);
    }

    public static <T> Result<T> fail(int code, String message, T data) {
        return new Result<>(code, message, data);
    }

    public boolean isSucceeded() {
        return code == 0 && data != null;
    }

    public boolean isFailed() {
        return code != 0 || data == null;
    }

    public int getCode() {
        return code;
    }

    public Result<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }
}
