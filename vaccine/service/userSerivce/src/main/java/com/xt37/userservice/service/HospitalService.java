package com.xt37.userservice.service;

import com.xt37.userservice.entity.Hospital;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xt37.userservice.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xt37
 * @since 2021-09-18
 */
public interface HospitalService extends IService<Hospital> {

    Hospital login(Hospital hospital);
}
