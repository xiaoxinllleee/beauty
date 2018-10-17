package com.venus.beauty.entity;

import lombok.Data;

/**
 * @author lx
 * @time 2018/10/17
 */
@Data
public class TokenInfo {
    /** token类型: api:0 、user:1 */
    private Integer tokenType;

    /** App 信息 */
    private AppInfo appInfo;

    /** 用户其他数据 */
    private UserInfo userInfo;
}
