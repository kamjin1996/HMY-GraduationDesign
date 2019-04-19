package com.zxx.hmy520.graduationdesign.domain.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.zxx.hmy520.graduationdesign.base.mysql.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 用户账号
 * </p>
 *
 * @author kam
 * @since 2019-04-19
 */
@Data
@ApiModel("用户账号")
public class User extends BaseModel {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名称
     */
    @TableField("user_name")
    @ApiModelProperty("用户名称")
    private String userName;
    /**
     * 密码
     */
    @TableField("password")
    @ApiModelProperty("密码")
    private String password;
    /**
     * 年龄
     */
    @TableField("age")
    @ApiModelProperty("年龄")
    private Integer age;


}
