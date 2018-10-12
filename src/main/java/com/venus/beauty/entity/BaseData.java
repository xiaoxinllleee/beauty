package com.venus.beauty.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author lx
 * @time 2018/10/12
 */
@Data
public class BaseData {
    private BigDecimal visitNumber;
    private String remark;
    private String baseId;
}
