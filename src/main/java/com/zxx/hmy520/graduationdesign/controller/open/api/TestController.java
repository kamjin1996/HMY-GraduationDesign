package com.zxx.hmy520.graduationdesign.controller.open.api;

import com.zxx.hmy520.graduationdesign.base.controller.BaseController;
import com.zxx.hmy520.graduationdesign.base.controller.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther: kam
 * @date: 8:38 2019-04-18
 * @description: 测试接口
 */
@RestController
@RequestMapping("/test")
@Api(value = "TestController", tags = "【测试接口】")
public class TestController extends BaseController {

    /**
     * 你好
     *
     * @return
     */
    @GetMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "你好", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponse(code = 200, message = "success", response = Result.class)
    public Result<Object> hello() {
        String hello = "Hello. Welcome join my world!";
        return response(hello);
    }

}
