package com.king.controller.utils;

import lombok.Data;

/**
 * @author codeking
 * @date 2022/4/19 16:16
 */
@Data
public class R {
    private Boolean flag ;
    private Object data;
    private String msg ;

    public R() {
    }

    public R(Boolean flag) {
        this.flag = flag;
    }

    public R(Boolean flag, Object date) {
        this.flag = flag;
        this.data = date;
    }

    public R(Boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    public R(String msg) {
        this.flag = false;
        this.msg = msg;
    }

}
