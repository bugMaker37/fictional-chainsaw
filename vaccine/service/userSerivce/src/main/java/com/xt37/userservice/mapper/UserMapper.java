package com.xt37.userservice.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xt37.userservice.entity.Injectiondetail;
import com.xt37.userservice.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xt37
 * @since 2021-09-18
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
