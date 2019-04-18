package com.zxx.hmy520.graduationdesign.base.controller.result;

/**
 * 错误状态码及消息
 */
public enum RestCodeConstants {
    /**
     * 请求成功
     */
    SUCCESS_200("success", 200),

    /**
     * 业务逻辑错误，或调用参数不正确
     */
    PARAMETER_ERROR_501("业务限制或请求参数不正确", 501),

    /**
     * 未登录，Token过期
     */
    UNAUTHORIZED_401("未登录或Token过期", 401),

    /**
     * 拒绝访问，没有相关权限
     */
    FORBIDDEN_403("没有相关权限", 403),

    /**
     * 请求资源不存或者URL错误
     */
    NOT_FOUND_404("服务器正在升级中，请稍后重试", 404),

    /**
     * 服务器内部错误
     */
    SYSTEM_ERROR_500("服务器繁忙，稍后重试", 500),

    /**
     * 网关错误,无法提供任何服务支持
     */
    GATEWAY_ERROR_502("网关错误", 502),

    /**
     * 服务不可用,子服务请求超时
     */
    SERVICE_UNAVAILABLE_503("请求超时或服务不可用", 503);


    /**
     * 返回消息
     */
    public final String msg;

    /**
     * 状态码
     */
    public final int code;


    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }


    RestCodeConstants(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }
}
