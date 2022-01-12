package com.xt37.userservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xt37.userservice.entity.Injectiondetail;
import com.xt37.userservice.entity.vo.InjectionQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xt37
 * @since 2021-09-18
 */
@Mapper
public interface InjectiondetailMapper extends BaseMapper<Injectiondetail> {
    List<InjectionQuery> selectDetail();

}
