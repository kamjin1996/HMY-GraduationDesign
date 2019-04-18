package com.zxx.hmy520.graduationdesign.base.controller.result;


/**
 * 服务器请求返回reponse 包装
 */
public final class BaseResponse {

    private BaseResponse() {
    }

    /**
     * 成功
     *
     * @return
     */
    public static <T> Result<T> getSuccessResult() {
        return BaseResponse.getResult(RestCodeConstants.SUCCESS_200);
    }

    /**
     * 成功
     *
     * @param obj
     * @return
     */
    public static <T> Result<T> getSuccessResult(T obj) {
        return new Result<T>(RestCodeConstants.SUCCESS_200.code, RestCodeConstants.SUCCESS_200.msg, obj);
    }

    /**
     * 参数错误
     *
     * @param msg 错误消息
     * @return
     */
    public static <T> Result<T> getParamErrorResult(String msg) {
        if (msg == null || msg.length() <= 0) {
            return BaseResponse.getResult(RestCodeConstants.PARAMETER_ERROR_501);
        }
        return new Result<T>(RestCodeConstants.PARAMETER_ERROR_501.code, msg);
    }


    /**
     * 参数错误
     *
     * @param msg 错误消息
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> Result<T> getParamErrorResult(String msg, T obj) {
        if (msg == null || msg.length() <= 0) {
            return new Result<T>(RestCodeConstants.PARAMETER_ERROR_501.code, msg, obj);
        }
        return new Result<T>(RestCodeConstants.PARAMETER_ERROR_501.code, msg, obj);
    }

    /**
     * 服务器内部错误
     *
     * @return
     */
    public static <T> Result<T> getSystemErrorResult() {
        return BaseResponse.getResult(RestCodeConstants.SYSTEM_ERROR_500);
    }

    /**
     * 服务器内部错误,消息自定义
     *
     * @return
     */
    public static <T> Result<T> getSystemErrorResult(String msg) {
        if (msg == null || msg.length() <= 0) {
            return BaseResponse.getSystemErrorResult();
        }
        return new Result<T>(RestCodeConstants.SYSTEM_ERROR_500.code, msg);
    }


    /**
     * 未登录 401
     *
     * @return
     */
    public static <T> Result<T> getUnauthorizedResult() {
        return BaseResponse.getResult(RestCodeConstants.UNAUTHORIZED_401);
    }

    /**
     * 拒绝访问 403
     *
     * @return
     */
    public static <T> Result<T> getForbiddenResult() {
        return BaseResponse.getResult(RestCodeConstants.FORBIDDEN_403);
    }


    /**
     * 资源或URL错误404
     *
     * @return
     */
    public static <T> Result<T> getNotFoundResult() {
        return BaseResponse.getResult(RestCodeConstants.NOT_FOUND_404);
    }


    /**
     * 子服务dowon，服务不可用
     *
     * @return
     */
    public static <T> Result<T> getServiceUnavailable() {
        return BaseResponse.getResult(RestCodeConstants.SERVICE_UNAVAILABLE_503);
    }

    /**
     * 获取返回值
     *
     * @param <T>
     * @return
     */
    public static <T> Result<T> getResult(RestCodeConstants restCode) {
        return new Result<T>(restCode.code, restCode.msg);
    }

}
