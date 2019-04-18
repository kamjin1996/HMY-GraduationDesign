package com.zxx.hmy520.graduationdesign.base.exception.handler;

import com.zxx.hmy520.graduationdesign.base.controller.result.BaseResponse;
import com.zxx.hmy520.graduationdesign.base.controller.result.Result;
import com.zxx.hmy520.graduationdesign.base.exception.BaseException;
import com.zxx.hmy520.graduationdesign.base.exception.FeignServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.List;

/**
 * @author kam
 * @Description: 异常处理
 * @date 2018/5/7 18:36
 */
@Slf4j
@RestControllerAdvice
public class ExceptionHandlerAdvice {

    /**
     * 系统错误 500
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Result<Object> handleException(Exception e) {
        log.error("\n【异常类别】: 系统异常", e);
        return BaseResponse.getSystemErrorResult();
    }


    /**
     * 服务调用异常
     *
     * @return
     */
    @ExceptionHandler(FeignServiceException.class)
    public Result<Object> handleFeignServiceException(FeignServiceException e) {
        log.debug("\n【异常类别】: 服务调用异常", e);
        return new Result<Object>(e.getCode(), e.getMsg());
    }

    /**
     * 基础业务逻辑异常
     *
     * @param e 501
     * @return
     */
    @ExceptionHandler(BaseException.class)
    public Result<Object> handleBaseException(Exception e) {
        log.debug("\n【异常类别】: 业务逻辑限制", e);
        return BaseResponse.getParamErrorResult(e.getMessage());
    }


    /**
     * 404
     *
     * @param e
     * @return
     */
    @ExceptionHandler({NoHandlerFoundException.class, HttpMediaTypeNotAcceptableException.class})
    public Result<Object> handleNoHandlerFoundException(Exception e) {
        log.debug("\n【异常类别】: 404 ", e);
        return BaseResponse.getNotFoundResult();
    }

    /**
     * 参数错误 501
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleIllegalParamException(MethodArgumentNotValidException e) {
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        String msg = "参数不合法";
        if (errors.size() > 0) {
            msg = errors.get(0).getDefaultMessage();
        }
        log.debug("\n【异常类别】请求参数不合法", e);
        return BaseResponse.getParamErrorResult(msg);
    }

    /**
     * 参数错误 501
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public Result MethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        log.debug("\n【异常类别】请求参数错误", e);
        return BaseResponse.getParamErrorResult("请求参数不合法");
    }

    /**
     * 参数错误
     *
     * @param e 501
     * @return
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.debug("\n【异常类别】请求参数错误", e);
        return BaseResponse.getParamErrorResult("请求参数不合法");
    }
    /**
     * 参数错误
     *
     * @param e 501
     * @return
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Result handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        log.debug("\n【异常类别】请求参数错误", e);
        return BaseResponse.getParamErrorResult("请求参数不合法");
    }
}
