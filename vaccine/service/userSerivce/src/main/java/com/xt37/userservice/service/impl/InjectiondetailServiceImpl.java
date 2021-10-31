package com.xt37.userservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xt37.userservice.entity.Injectiondetail;
import com.xt37.userservice.entity.Veccines;
import com.xt37.userservice.entity.vo.injectionQuery;
import com.xt37.userservice.entity.vo.vaccineQuery;
import com.xt37.userservice.mapper.HospitalMapper;
import com.xt37.userservice.mapper.InjectiondetailMapper;
import com.xt37.userservice.mapper.UserMapper;
import com.xt37.userservice.mapper.VeccinesMapper;
import com.xt37.userservice.service.InjectiondetailService;
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
public class InjectiondetailServiceImpl extends ServiceImpl<InjectiondetailMapper, Injectiondetail> implements InjectiondetailService {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private HospitalMapper hospitalMapper;

    @Autowired
    private VeccinesMapper veccinesMapper;


    @Override
    public IPage<Injectiondetail> getPage(String hospitalId, vaccineQuery vaccineQuery, int current, int limit) {
        injectionQuery injectionQuery = new injectionQuery();
        Page<Injectiondetail> page = new Page<>(current, limit);

        QueryWrapper<Injectiondetail> wrapper = new QueryWrapper<>();

        wrapper.eq("hospitalId", hospitalId);
        //根据条件查询 再wrapper中添加查询条件
        if (vaccineQuery.getType() != null) {
            wrapper.eq("type", vaccineQuery.getType());
        }

        IPage<Injectiondetail> iPage = this.page(page, wrapper);


        return iPage;
    }

    @Override
    public void updateInjectionById(String injectionId, injectionQuery injectionQuery) {
        Veccines veccines = veccinesMapper.selectById(injectionId);


    }

}
