package com.zxx.hmy520.graduationdesign.domain.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
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
 * @since 2019-04-20
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
     * 用户头像
     */
    @TableField("logo")
    @ApiModelProperty("用户头像")
    private String logo;
    /**
     * 账户密码
     */
    @TableField("pass_word")
    @ApiModelProperty("账户密码")
    private String passWord;
    /**
     * 用户性别
     */
    @TableField("age")
    @ApiModelProperty("用户性别")
    private Integer age;
    /**
     * 手机号码
     */
    @TableField("mobile")
    @ApiModelProperty("手机号码")
    private String mobile;


}
