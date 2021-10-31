package com.xt37.userservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xt37.commentUtils.R;
import com.xt37.userservice.entity.Injectiondetail;
import com.xt37.userservice.entity.vo.injectionQuery;
import com.xt37.userservice.entity.vo.vaccineQuery;
import com.xt37.userservice.mapper.HospitalMapper;
import com.xt37.userservice.mapper.InjectiondetailMapper;
import com.xt37.userservice.mapper.UserMapper;
import com.xt37.userservice.mapper.VeccinesMapper;
import com.xt37.userservice.service.InjectiondetailService;
import com.xt37.userservice.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xt37
 * @since 2021-09-18
 */
@RestController
@RequestMapping("/userservice/injection")
@CrossOrigin
public class InjectiondetailController {
    @Autowired
    private InjectiondetailService injectionService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private HospitalMapper hospitalMapper;

    @Autowired
    private VeccinesMapper veccinesMapper;


    //查找全部的疫苗信息
    @GetMapping("findAll/{hospitalId}")
    public R findAll(@PathVariable String hospitalId) {
        QueryWrapper<Injectiondetail> wrapper = new QueryWrapper<>();
        wrapper.eq("hospitalId", hospitalId);
        List<Injectiondetail> list = injectionService.list(wrapper);
        return R.ok().data("list", list);
    }

    //条件查询代分页
    @PostMapping("getPagelist/{hospitalId}")
    public R getPageList(@PathVariable String hospitalId,
                         @RequestBody vaccineQuery vaccineQuery) {
        IPage page = injectionService.getPage(hospitalId, vaccineQuery, 1, 8);
        long total = page.getTotal();
        List records = page.getRecords();

        List<injectionQuery> list = new ArrayList<>();

        for (int i = 0; i < records.size(); ++i) {
            injectionQuery query = new injectionQuery();

            Injectiondetail injectiondetail = (Injectiondetail) records.get(i);

            if (userMapper.selectById(injectiondetail.getUserId()) != null) {
                query.setUserName(userMapper.selectById(injectiondetail.getUserId()).getUserName());
            }
            if (hospitalMapper.selectById(injectiondetail.getHospitalId()) != null) {
                query.setHospName(hospitalMapper.selectById(injectiondetail.getHospitalId()).getUserName());
            }
            if (veccinesMapper.selectById(injectiondetail.getVaccineId()) != null) {
                query.setVaccineName(veccinesMapper.selectById(injectiondetail.getVaccineId()).getVaccinesBrand());
            }
            query.setInjectionTime(injectiondetail.getInjectionTime());
            query.setDescription(injectiondetail.getDecriptioin());
            query.setType(injectiondetail.getType());
            query.setGmtCreate(injectiondetail.getGmtCreate());
            query.setGmtModified(injectiondetail.getGmtModified());

            System.out.println(query);
            list.add(query);
        }
        return R.ok().data("total", total).data("records", records);
    }


    @PostMapping("update/{injectionId}")
    public R updateInjection(@PathVariable String injectionId,
                             @RequestBody injectionQuery injectionQuery) {
        injectionService.updateInjectionById(injectionId,injectionQuery);

        return R.ok();
    }

}

