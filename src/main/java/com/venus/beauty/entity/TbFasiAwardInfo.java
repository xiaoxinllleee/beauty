package com.venus.beauty.entity;

import lombok.Data;

/**
 * @author lx
 * @time 2018/9/10
 */
@Data
public class TbFasiAwardInfo {
    /**
     * 主键ID
     */
    private String id;
    /**
     * 获奖名称
     */
    private String awardName;
    /**
     * 获奖学期
     */
    private String awardTerm;
    /**
     * 获奖级别 1-校级 2-院级 3-其他
     */
    private String awardLevel;
    /**
     * 获奖名次
     */
    private String awardRanking;
    /**
     * 获奖人姓名
     */
    private String awardUserName;
    /**
     * 获奖人身份证号
     */
    private String awardUserSfzh;
}
