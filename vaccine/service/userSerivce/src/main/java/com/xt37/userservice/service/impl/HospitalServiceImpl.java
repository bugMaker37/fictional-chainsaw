package com.xt37.userservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xt37.userservice.entity.Hospital;
import com.xt37.userservice.mapper.HospitalMapper;
import com.xt37.userservice.service.HospitalService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xt37
 * @since 2021-09-18
 */
@Service
public class HospitalServiceImpl extends ServiceImpl<HospitalMapper, Hospital> implements HospitalService {

    @Override
    public Hospital login(Hospital hospital) {
        QueryWrapper<Hospital> wrapper = new QueryWrapper<>();
        wrapper.eq("userName",hospital.getUserName());
        wrapper.eq("password",hospital.getPassword());

        Hospital one = this.getOne(wrapper);
        return one;
    }
}
