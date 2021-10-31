package com.xt37.userservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xt37.userservice.entity.Hospital;
import com.xt37.userservice.entity.Veccines;
import com.xt37.userservice.entity.vo.vaccineQuery;
import com.xt37.userservice.mapper.VeccinesMapper;
import com.xt37.userservice.service.HospitalService;
import com.xt37.userservice.service.VeccinesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author xt37
 * @since 2021-09-18
 */
@Service
public class VeccinesServiceImpl extends ServiceImpl<VeccinesMapper, Veccines> implements VeccinesService {

    @Autowired
    private HospitalService hospitalService;

    public IPage<Veccines> getVaccine(String hospital, long current, long limit) {

        Page<Veccines> veccinesPage = new Page<>(current, limit);
        QueryWrapper<Hospital> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId", hospital);
        Hospital hospitalById = hospitalService.getOne(queryWrapper);
        QueryWrapper<Veccines> wrapper = new QueryWrapper<>();

        IPage<Veccines> page = this.page(veccinesPage, wrapper);
        return page;
    }

    @Override
    public IPage<Veccines> getVaccine(vaccineQuery query, String hospital, long current, long limit) {
        Page<Veccines> veccinesPage = new Page<>(current, limit);
        //查找医院id下的疫苗
        QueryWrapper<Hospital> hospitalQueryWrapper = new QueryWrapper<>();
        hospitalQueryWrapper.eq("userId",hospital);
        Hospital byId = hospitalService.getOne(hospitalQueryWrapper);
        //根据query添加查询条件
        QueryWrapper<Veccines> wrapper = new QueryWrapper<>();
        wrapper.eq("hospital", byId.getUserName());
        //添加查询条件  如果条件不为空添加判断
        String vaccinesBrand = query.getVaccinesBrand();
        Integer type = query.getType();
        String begin = query.getBegin();
        String end = query.getEnd();

        if (!StringUtils.isEmpty(vaccinesBrand)) {
            wrapper.eq("vaccinesBrand", vaccinesBrand);
        }
        if (type != null) {
            wrapper.eq("type", type);
        }
        if (!StringUtils.isEmpty(begin)) {
            wrapper.ge("gmt_create", begin);
        }
        if (!StringUtils.isEmpty(end)) {
            wrapper.ge("gmt_create", end);
        }
        wrapper.orderByDesc("gmt_create");
        IPage<Veccines> page = this.page(veccinesPage, wrapper);
        return page;
    }
}
