package com.zxx.hmy520.graduationdesign.controller.open.api;

import com.baomidou.mybatisplus.plugins.Page;

import com.zxx.hmy520.graduationdesign.base.controller.result.Result;
import com.zxx.hmy520.graduationdesign.domain.query.UserQuery;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.zxx.hmy520.graduationdesign.domain.model.User;
import com.zxx.hmy520.graduationdesign.service.open.UserService;

import org.springframework.web.bind.annotation.RestController;
import com.zxx.hmy520.graduationdesign.base.controller.BaseController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kam
 * @since 2019-04-19
 */
@RestController
@RequestMapping("/user")
@Api(value = "UserController", tags = "【】")
public class UserController extends BaseController {

    @Autowired
    public UserService userService;

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "根据ID查询", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponse(code = 200, message = "success", response = Result.class)
    public Result<User> loadById(@PathVariable(value = "id") Long id) {
        return response(this.userService.findById(id));
    }


    /**
     * 分页查询
     *
     * @param query
     * @return
     */
    @GetMapping(value = "/page", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "总分页查询", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponse(code = 200, message = "success", response = Result.class)
    public Result<Page<User>> loadByPage(UserQuery query) {
        return response(this.userService.findByPage(query));
    }

    /**
     * 新增
     *
     * @param user
     * @return
     */
    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "新增", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponse(code = 200, message = "success", response = Result.class)
    public Result<Boolean> add(@RequestBody User user) {
        return response(this.userService.add(user));
    }

    /**
     * 修改
     *
     * @param user
     * @return
     */
    @PutMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改", httpMethod = "PUT", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponse(code = 200, message = "success", response = Result.class)
    public Result<Boolean> update(@RequestBody User user) {
        return response(this.userService.update(user));
    }


    /**
     * 根据ID删除
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "根据ID删除", httpMethod = "DELETE", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponse(code = 200, message = "success", response = Result.class)
    public Result<Object> delete(@PathVariable(value = "id") Long id) {
        this.userService.delete(id);
        return response();
    }

}

