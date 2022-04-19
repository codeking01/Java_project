package com.king.controller.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author codeking
 * @date 2022/4/19 16:16
 */
@Data
public class R {
    private Boolean flag ;
    private Object data;

    public R() {
    }

    public R(Boolean flag) {
        this.flag = flag;
    }

    public R(Boolean flag, Object date) {
        this.flag = flag;
        this.data = date;
    }
}
