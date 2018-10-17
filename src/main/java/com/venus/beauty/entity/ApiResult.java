package com.venus.beauty.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lx
 * @time 2018/10/17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResult {
    /** 代码 */
    private String code;

    /** 结果 */
    private String msg;
}
