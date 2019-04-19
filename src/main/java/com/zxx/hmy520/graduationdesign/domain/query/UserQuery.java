package com.zxx.hmy520.graduationdesign.domain.query;

import com.zxx.hmy520.graduationdesign.domain.model.User;
import com.zxx.hmy520.graduationdesign.base.mysql.page.PageHelp;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * <p>
 * 用户账号分页查询
 * </p>
 *
 * @author kam
 * @since 2019-04-19
 */
@Data
@ApiModel("用户账号分页查询")
public class UserQuery extends PageHelp<User> {

    private static final long serialVersionUID = 1L;


}
