package com.xt37.userservice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xt37.userservice.entity.Injectiondetail;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xt37.userservice.entity.vo.injectionQuery;
import com.xt37.userservice.entity.vo.vaccineQuery;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xt37
 * @since 2021-09-18
 */
public interface InjectiondetailService extends IService<Injectiondetail> {

    IPage getPage(String hospitalId, vaccineQuery vaccineQuery,int current,int limit);

    void updateInjectionById(String injectionId, injectionQuery injectionQuery);
}
