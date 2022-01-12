package com.xt37.userservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xt37.commentUtils.R;
import com.xt37.userservice.entity.Injectiondetail;
import com.xt37.userservice.entity.Veccines;
import com.xt37.userservice.entity.vo.InjectionQuery;
import com.xt37.userservice.entity.vo.vaccineQuery;
import com.xt37.userservice.mapper.HospitalMapper;
import com.xt37.userservice.mapper.UserMapper;
import com.xt37.userservice.mapper.VeccinesMapper;
import com.xt37.userservice.service.InjectiondetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    /**
     * 条件查询带分页
     *
     * @param hospitalId
     * @param vaccineQuery
     * @return
     */
    @PostMapping("getPageList/{hospitalId}")
    public R getPageList(@PathVariable String hospitalId,
                         @RequestBody vaccineQuery vaccineQuery) {
        IPage page = injectionService.getPage(hospitalId, vaccineQuery, 1, 8);
        long total = page.getTotal();
        List records = page.getRecords();
        return R.ok().data("total", total).data("records", records);
    }

    /**
     * 更新详细信息
     *
     * @param injectionId
     * @param injectionQuery
     * @return
     */
    @PostMapping("update/{injectionId}")
    public R updateInjection(@PathVariable String injectionId,
                             @RequestBody InjectionQuery injectionQuery) {
        injectionService.updateInjectionById(injectionId, injectionQuery);
        return R.ok();
    }

    @GetMapping("getDetail/{injectionId}")
    public R getDetailById(@PathVariable String injectionId) {
        Injectiondetail byId = injectionService.getById(injectionId);
        List<Veccines> veccines = veccinesMapper.selectList(null);
        return R.ok().data("detail", byId).data("veccines",veccines);
    }

}

