package com.xt37.userservice.service;

import com.xt37.userservice.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xt37
 * @since 2021-09-18
 */
public interface UserService extends IService<User> {

    User login(User user);

    User regist(User user);

}
