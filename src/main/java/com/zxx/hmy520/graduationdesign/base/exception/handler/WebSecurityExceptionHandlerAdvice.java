package com.zxx.hmy520.graduationdesign.base.exception.handler;

import com.zxx.hmy520.graduationdesign.base.controller.result.BaseResponse;
import com.zxx.hmy520.graduationdesign.base.controller.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;

/**
 * @author kam
 * @Description: 异常处理
 * @date 2018/5/7 18:36
 */
@Slf4j
@RestControllerAdvice
public class WebSecurityExceptionHandlerAdvice extends ExceptionHandlerAdvice {
    /**
     * 用户未认证登录 401
     *
     * @param e
     * @return
     */
    @ExceptionHandler(AccessDeniedException.class)
    public Result AccessDeniedException(AccessDeniedException e) {
        log.debug("\n【异常类别】用户未认证登录", e);
        return BaseResponse.getUnauthorizedResult();
    }
}
