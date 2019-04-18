package com.zxx.hmy520.graduationdesign.base.exception.handler;

import com.zxx.hmy520.graduationdesign.base.controller.result.BaseResponse;
import com.zxx.hmy520.graduationdesign.base.controller.result.Result;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author kam
 * @Description: error 页面处理
 * @date 2018/5/8 14:07
 */
@Controller
public class RestNotFoundController implements ErrorController {

    private static final String ERROR_PATH = "/error";

    @ResponseBody
    @RequestMapping(value = ERROR_PATH)
    @ResponseStatus(code = HttpStatus.OK)
    public Result<Object> handleError(HttpServletRequest request, HttpServletResponse response) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode != null) {
            if (statusCode == 404) {
                return BaseResponse.getNotFoundResult();
            } else if (statusCode == 401) {
                return BaseResponse.getUnauthorizedResult();
            } else if (statusCode == 403) {
                return BaseResponse.getForbiddenResult();
            }
        }
        return BaseResponse.getSystemErrorResult();
    }


    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}