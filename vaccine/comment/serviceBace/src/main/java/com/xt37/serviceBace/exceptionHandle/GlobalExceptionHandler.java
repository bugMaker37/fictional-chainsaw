package com.xt37.serviceBace.exceptionHandle;


import com.xt37.commentUtils.R;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Log4j
public class GlobalExceptionHandler {

    //指定异常处理的错误
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e){
        e.printStackTrace();
        return R.error().message("执行了全局异常处理");
    }

    //指定特定的异常
    //特定异常
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody //为了返回数据
    public R error(ArithmeticException e) {
        e.printStackTrace();
        return R.error().message("执行了ArithmeticException异常处理..");
    }

    //自定义异常
    @ExceptionHandler(vaccineException.class)
    @ResponseBody //为了返回数据
    public R error(vaccineException e) {
        e.printStackTrace();

        return R.error().code(e.getCode()).message(e.getMessage());
    }
}
