package com.zxx.hmy520.graduationdesign.domain.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.zxx.hmy520.graduationdesign.base.mysql.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author kam
 * @since 2019-04-19
 */
@Data
@ApiModel("")
public class User extends BaseModel {

    private static final long serialVersionUID = 1L;

    @TableField("username")
    @ApiModelProperty("")
    private String username;
    @TableField("password")
    @ApiModelProperty("")
    private String password;
    @TableField("age")
    @ApiModelProperty("")
    private Integer age;


}
