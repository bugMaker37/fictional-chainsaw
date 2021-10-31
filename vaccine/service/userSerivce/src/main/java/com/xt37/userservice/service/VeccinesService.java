package com.xt37.userservice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xt37.userservice.entity.Veccines;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xt37.userservice.entity.vo.vaccineQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xt37
 * @since 2021-09-18
 */
public interface VeccinesService extends IService<Veccines> {

    IPage<Veccines> getVaccine(vaccineQuery query, String hospital, long current, long limit);
}
