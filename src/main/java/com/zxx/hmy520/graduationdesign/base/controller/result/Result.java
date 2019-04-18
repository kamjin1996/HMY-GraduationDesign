package com.zxx.hmy520.graduationdesign.base.controller.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.collect.Maps;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Map;
import java.util.Objects;

@Data
@ApiModel(value = "Result", description = "")
public class Result<T> {
    /**
     * 默认返回值数据,保持{}
     */
    public static final Map defaultMap = Maps.newHashMap();

    @ApiModelProperty(value = "状态码.200(OK)")
    private int code;

    @ApiModelProperty(value = "返回的消息")
    private String msg;

    @JsonInclude(value = JsonInclude.Include.NON_DEFAULT)
    @ApiModelProperty(value = "返回的数据")
    private T data = (T) defaultMap;

    @ApiModelProperty(value = "系统时间")
    private long timestamp = System.currentTimeMillis();

    public Result() {
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        if (Objects.nonNull(data)) {
            this.data = data;
        }
    }

}
