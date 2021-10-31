package com.xt37.userservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xt37.userservice.entity.User;
import com.xt37.userservice.mapper.UserMapper;
import com.xt37.userservice.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author xt37
 * @since 2021-09-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User login(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("userName", user.getUserName());
        wrapper.eq("password", user.getPassword());
        User one = this.getOne(wrapper);
        return one;
    }

    @Override
    public User regist(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("userName",user.getUserName());

        User one = this.getOne(wrapper);
        return one;
    }
}
