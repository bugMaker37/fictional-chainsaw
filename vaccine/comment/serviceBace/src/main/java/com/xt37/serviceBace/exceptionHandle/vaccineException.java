package com.xt37.serviceBace.exceptionHandle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor  //生成有参数构造方法
@NoArgsConstructor
public class vaccineException extends RuntimeException {
    private Integer code;
    private String message;
}
