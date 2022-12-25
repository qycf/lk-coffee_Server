package com.lkcoffee.exception;

import com.lkcoffee.result.ResultCode;
import lombok.Getter;


@Getter
public class APIException extends RuntimeException {

    private int code;
    private String msg;

    public APIException() {
        this(ResultCode.FAILED);
    }

    public APIException(ResultCode failed) {
        this.code = failed.getCode();
        this.msg = failed.getMsg();
    }

    public APIException(String msg) {
        this.code = ResultCode.FAILED.getCode();
        this.msg = msg;
    }
}