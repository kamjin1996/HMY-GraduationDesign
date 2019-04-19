package com.zxx.hmy520.graduationdesign.service.open.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zxx.hmy520.graduationdesign.domain.model.User;
import com.zxx.hmy520.graduationdesign.domain.query.UserQuery;
import com.zxx.hmy520.graduationdesign.mapper.UserMapper;
import com.zxx.hmy520.graduationdesign.service.open.UserService;
import com.zxx.hmy520.graduationdesign.base.mysql.service.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户账号 服务实现类
 * </p>
 *
 * @author kam
 * @since 2019-04-19
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User findById(Long id) {
        return this.selectById(id);
    }

    @Override
    public Page<User> findByPage(UserQuery query) {
        Wrapper<User> wrapper = new EntityWrapper<>();
        return this.selectPage(query.getPage(), wrapper);
    }

    @Override
    public void delete(Long id) {
        this.deleteById(id);
    }

    @Override
    public boolean add(User user) {
        return this.insert(user);
    }

    @Override
    public boolean update(User user) {
        return this.updateById(user);
    }

}
