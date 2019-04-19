package com.zxx.hmy520.graduationdesign.service.open;

import com.baomidou.mybatisplus.plugins.Page;
import com.zxx.hmy520.graduationdesign.domain.model.User;
import com.zxx.hmy520.graduationdesign.domain.query.UserQuery;
import com.zxx.hmy520.graduationdesign.base.mysql.service.BaseService;

/**
 * <p>
 * 用户账号 服务类
 * </p>
 *
 * @author kam
 * @since 2019-04-19
 */
public interface UserService extends BaseService<User> {

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    User findById(Long id);

    /**
     * 分页查询
     *
     * @param query
     * @return
     */
    Page<User> findByPage(UserQuery query);

    /**
     * 新增
     *
     * @param user
     */
    boolean add(User user);

    /**
     * 修改
     *
     * @param user
     * @return
     */
    boolean update(User user);

    /**
     * 根据ID删除
     *
     * @param id
     */
    void delete(Long id);
}
