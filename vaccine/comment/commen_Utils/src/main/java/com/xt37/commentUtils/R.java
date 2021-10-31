package com.xt37.commentUtils;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目的返回类
 */
@Data
public class R {

    private String message;

    private Integer code;

    private Boolean success;

    private Map<String, Object> data = new HashMap<>();

    private void R() {

    }

    public static R ok() {
        R r = new R();
        r.setSuccess(true);
        r.setCode(20000);
        r.setMessage("成功");
        return r;
    }

    public static R error() {
        R r = new R();
        r.setSuccess(false);
        r.setCode(20001);
        r.setMessage("失败");
        return r;
    }

    public R success(Boolean success) {
        this.setSuccess(success);
        return this;
    }

    public R message(String message) {
        this.setMessage(message);
        return this;
    }

    public R code(Integer code) {
        this.setCode(code);
        return this;
    }

    public R data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public R data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }

}
