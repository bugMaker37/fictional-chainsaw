package com.xt37.userservice.entity.vo;

import lombok.Data;

import java.util.Date;

@Data
public class InjectionQuery {

    private String injectionId;

    //患者名字
    private String userName;

    //预约的医院的名字
    private String hospName;
    //疫苗的名字
    private String vaccineName;
    //详细信息
    private String description;
    //注射的次数
    private Integer type;

    private Date injectionTime;
    //生成 更新时间
    private Date gmtCreate;
    private Date gmtModified;
}
