package com.zxx.hmy520.graduationdesign.base.controller;


import com.zxx.hmy520.graduationdesign.base.controller.result.BaseResponse;
import com.zxx.hmy520.graduationdesign.base.controller.result.Result;


/**
 * 控制器基类
 */
public abstract class BaseController {

    /**
     * 返回操作成功
     *
     * @return
     */
    protected Result<Object> response() {
        return BaseResponse.getSuccessResult();
    }

    /**
     * 返回成功数据
     *
     * @param data 参数
     * @param <T>
     * @return
     */
    protected <T> Result<T> response(T data) {
        return BaseResponse.getSuccessResult(data);
    }

    /**
     * 返回错误消息
     *
     * @param <T>
     * @return
     */
    protected <T> Result<T> responseMsg(String msg) {
        return BaseResponse.getParamErrorResult(msg);
    }

    /**
     * 返回错误消息
     *
     * @param msg 错误消息
     * @param obj 参数
     * @param <T>
     * @return
     */
    protected <T> Result<T> responseMsg(String msg, T obj) {
        return BaseResponse.getParamErrorResult(msg, obj);
    }
}
