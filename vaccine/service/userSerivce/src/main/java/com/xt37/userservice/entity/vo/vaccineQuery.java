package com.xt37.userservice.entity.vo;

import lombok.Data;

@Data
public class vaccineQuery {
    private String vaccinesBrand;
    private Integer type;
    private String begin;
    private String end;
}
