package com.venus.beauty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author lx
 * @time 2018/9/28
 */
@Component
public class SchedulingTask {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Scheduled(fixedRate = 10000)
    public void reportCurrentTime() {
        jdbcTemplate.update("insert into SCHEDULED value(?,?,?,?)",new Object[]{dateFormat.format(new Date()),
        "定时任务的demo",UUID.randomUUID().toString(),"task_system"});
        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }
}
