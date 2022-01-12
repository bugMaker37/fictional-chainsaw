package com.xt37.userservice.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xt37.commentUtils.R;
import com.xt37.userservice.entity.Veccines;
import com.xt37.userservice.entity.vo.vaccineQuery;
import com.xt37.userservice.service.VeccinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/userservice/veccines")
@CrossOrigin
public class VeccinesController {

    @Autowired
    private VeccinesService veccineService;

    //查询带分页
    @PostMapping("getPageList/{hospitalId}")
    public R vaccine(@PathVariable String hospitalId,
                     @RequestBody vaccineQuery vaccineQuery) {
        IPage<Veccines> vaccine = veccineService.getVaccine(vaccineQuery, hospitalId, 1, 8);
        List<Veccines> records = vaccine.getRecords();
        long total = vaccine.getTotal();
        return R.ok().data("total", total).data("records", records);
    }

    @GetMapping("/getVaccine/{id}")
    public R getById(@PathVariable String id) {
        Veccines veccines = veccineService.getById(id);
        return veccines != null ? R.ok().data("vaccine", veccines) : R.error();
    }

    //添加疫苗信息
    @PostMapping("save")
    public R save(@RequestBody Veccines veccines) {
        boolean save = veccineService.save(veccines);
        return save ? R.ok() : R.error();
    }

    @PostMapping("updateVaccine")
    public R updateVaccine(@RequestBody Veccines veccines) {
        boolean b = veccineService.updateById(veccines);
        return b ? R.ok() : R.error();
    }

    @DeleteMapping("delete/{id}")
    public R delete(@PathVariable String id) {
        boolean b = veccineService.removeById(id);
        return b ? R.ok() : R.error();
    }
}

