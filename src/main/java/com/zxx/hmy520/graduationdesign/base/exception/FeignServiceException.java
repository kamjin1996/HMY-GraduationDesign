package com.zxx.hmy520.graduationdesign.base.exception;


import lombok.Data;

/**
 * 服务调用异常
 */
@Data
public class FeignServiceException extends RuntimeException {

    private int code;

    private String msg;

    public FeignServiceException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
